package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.agc.LigneDepense;
import ci.gouv.dgbf.domain.agc.LigneOperation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class LigneDepenseService {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    EntityManager em;

    private final String baseQuery="SELECT ldi FROM V_LIGNE_DEPENSE_IMPUTABLE ldi ";
    private final String countBaseQuery="SELECT COUNT(*) FROM V_LIGNE_DEPENSE_IMPUTABLE lde ";

    public List<LigneDepense> findAll(){
        TypedQuery<LigneDepense> query = em.createQuery(baseQuery, LigneDepense.class);
        return query.getResultList();
    }

    public List<LigneDepense> findByActiviteCode(String activiteCode){
        String queryString= baseQuery.concat(" WHERE ld.activiteCode = :activiteCode");

        TypedQuery<LigneDepense> query = em.createQuery(queryString, LigneDepense.class);
        query.setParameter("activiteCode", activiteCode);
        return query.getResultList();
    }

    public List<LigneDepense> findByNatureEconomiqueCode(String natureEconomiqueCode){
        String queryString= baseQuery.concat(" WHERE ld.natureEconomiqueCode = :natureEconomiqueCode");

        TypedQuery<LigneDepense> query = em.createQuery(queryString, LigneDepense.class);
        query.setParameter("natureEconomiqueCode", natureEconomiqueCode);
        return query.getResultList();
    }

    public List<LigneDepense> findByOperation(List<LigneOperation> ligneOperationList){
        List<LigneDepense> ligneDepenseList = new ArrayList<>();
        ligneOperationList.stream()
                .map(operation -> findByCritere(operation.exercice, operation.sourceFinancementCode, operation.natureEconomiqueCode,
                operation.activiteCode, operation.bailleurCode, "", "", "", ""))
                .forEach(ligneDepenseList::addAll);
        return ligneDepenseList;
    }

    @Transactional
    public List<LigneDepense> findByCriterePaginated(String exercice, String sourceFinancement, String natureEconomiqueCode, String activiteCode,
                                            String bailleur, String sectionCode, String natureDepense, String programme, String action, int indexPremierElement, int nombreElements){
        String queryString= this.buildQuery(baseQuery, exercice, sourceFinancement,natureEconomiqueCode, activiteCode, bailleur, sectionCode, natureDepense, programme, action);
        TypedQuery<LigneDepense> query = em.createQuery(queryString, LigneDepense.class);
        LOG.info("====> query created");
        if(indexPremierElement != 0 && nombreElements != 0) {
            query.setFirstResult(indexPremierElement).setMaxResults(nombreElements);
        } else {
            query.setMaxResults(100);
        }
        LOG.info("====> query firstResult and maxResult set");
        this.setParameters(exercice, sourceFinancement,natureEconomiqueCode, activiteCode, bailleur, sectionCode, natureDepense, programme, action, query);
        LOG.info("====> query parameters set");
        return query.getResultList();
    }

    @Transactional
    public List<LigneDepense> findByCritere(String exercice, String sourceFinancement, String natureEconomiqueCode, String activiteCode,
                                            String bailleur, String sectionCode, String natureDepense, String programme, String action){
        String queryString= this.buildQuery(baseQuery, exercice, sourceFinancement,natureEconomiqueCode, activiteCode, bailleur, sectionCode, natureDepense, programme, action);
        TypedQuery<LigneDepense> query = em.createQuery(queryString, LigneDepense.class);
        this.setParameters(exercice, sourceFinancement,natureEconomiqueCode, activiteCode, bailleur, sectionCode, natureDepense, programme, action, query);
        return query.getResultList();
    }

    @Transactional
    public long countByCritere(String exercice, String sourceFinancement, String natureEconomiqueCode, String activiteCode,
                               String bailleur, String sectionCode, String natureDepense, String programme, String action){
        String queryString= this.buildQuery(countBaseQuery, exercice, sourceFinancement,natureEconomiqueCode, activiteCode, bailleur, sectionCode, natureDepense, programme, action);
        TypedQuery<Long> query = em.createQuery(queryString, Long.class);
        this.setParameters(exercice, sourceFinancement,natureEconomiqueCode, activiteCode, bailleur, sectionCode, natureDepense, programme, action, query);
        return query.executeUpdate();
    }

    private String buildQuery(String query, String exercice, String sourceFinancement, String natureEconomiqueCode, String activiteCode,
                              String bailleur, String sectionCode, String natureDepense, String programme, String action){
        String queryString = query.concat("WHERE exercice = :exercice");

        if(sourceFinancement!=null && !sourceFinancement.equals(""))
            queryString = queryString.concat(" AND sourceFinancementCode = :sourceFinancementCode");

        if(natureEconomiqueCode!=null && !natureEconomiqueCode.equals(""))
            queryString = queryString.concat(" AND natureEconomiqueCode = :natureEconomiqueCode");

        if(activiteCode!=null && !activiteCode.equals(""))
            queryString = queryString.concat(" AND activiteCode = :activiteCode");

        if(bailleur!=null && !bailleur.equals(""))
            queryString = queryString.concat(" AND bailleurId = :bailleurId");

        if(sectionCode!=null && !sectionCode.equals(""))
            queryString = queryString.concat(" AND sectionCode = :sectionCode");

        if(natureDepense!=null && !natureDepense.equals(""))
            queryString = queryString.concat(" AND natureDepense = :natureDepense");

        if(programme!=null && !programme.equals(""))
            queryString = queryString.concat(" AND usbCode = :usbCode");

        if(action!=null && !action.equals(""))
            queryString = queryString.concat(" AND actionCode = :actionCode");

        LOG.info("REQUETE : "+queryString);
        return queryString;
    }

    private void setParameters(String exercice, String sourceFinancement, String natureEconomiqueCode, String activiteCode,
                               String bailleur, String sectionCode, String natureDepense, String programme, String action,
                               TypedQuery<?> query){

        if(exercice!=null && !exercice.equals(""))
            query.setParameter("exercice", exercice);

        if(sourceFinancement!=null && !sourceFinancement.equals(""))
            query.setParameter("sourceFinancementCode", sourceFinancement);

        if(natureEconomiqueCode!=null && !natureEconomiqueCode.equals(""))
            query.setParameter("natureEconomiqueCode", natureEconomiqueCode);

        if(activiteCode!=null && !activiteCode.equals(""))
            query.setParameter("activiteCode", activiteCode);

        if(bailleur!=null && !bailleur.equals(""))
            query.setParameter("bailleurId", bailleur);

        if(sectionCode!=null && !sectionCode.equals(""))
            query.setParameter("sectionCode", sectionCode);

        if(natureDepense!=null && !natureDepense.equals(""))
            query.setParameter("natureDepense", natureDepense);

        if(programme!=null && !programme.equals(""))
            query.setParameter("usbCode", programme);

        if(action!=null && !action.equals(""))
            query.setParameter("actionCode", action);
    }
}
