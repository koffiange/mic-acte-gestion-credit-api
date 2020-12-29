package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.LigneDepense;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class LigneDepenseService {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());
    @Inject
    EntityManager em;

    private final String baseQuery="SELECT ld FROM V_LIGNE_DEPENSE ld";

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


    public List<LigneDepense> findByCritere(String natureEconomiqueCode, String activiteCode, String sectionCode){
        String queryString= this.buildQuery(natureEconomiqueCode, activiteCode, sectionCode);
        TypedQuery<LigneDepense> query = em.createQuery(queryString, LigneDepense.class);
        this.setParameters(natureEconomiqueCode, activiteCode, sectionCode, query);
        return query.getResultList();
    }

    private String buildQuery(String natureEconomiqueCode, String activiteCode, String sectionCode){
        String queryString= baseQuery.concat(" WHERE 1=1");

        if(natureEconomiqueCode!=null && !natureEconomiqueCode.equals(""))
            queryString = queryString.concat(" AND natureEconomiqueCode = :natureEconomiqueCode");

        if(activiteCode!=null && !activiteCode.equals(""))
            queryString = queryString.concat(" AND activiteCode = :activiteCode");

        if(sectionCode!=null && !sectionCode.equals(""))
            queryString = queryString.concat(" AND sectionCode = :sectionCode");

        LOG.info("REQUETE : "+queryString);
        return queryString;
    }

    private void setParameters(String natureEconomiqueCode, String activiteCode, String sectionCode, TypedQuery<LigneDepense> query){
        if(natureEconomiqueCode!=null && !natureEconomiqueCode.equals(""))
            query.setParameter("natureEconomiqueCode", natureEconomiqueCode);

        if(activiteCode!=null && !activiteCode.equals(""))
            query.setParameter("activiteCode", activiteCode);

        if(sectionCode!=null && !sectionCode.equals(""))
            query.setParameter("sectionCode", sectionCode);
    }
}
