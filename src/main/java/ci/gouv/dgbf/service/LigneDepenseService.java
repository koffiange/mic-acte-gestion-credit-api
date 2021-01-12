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


    public List<LigneDepense> findByCritere(String natureEconomiqueCode, String activiteCode, String sectionCode,
                                            String natureDepense, String programme, String action){
        String queryString= this.buildQuery(natureEconomiqueCode, activiteCode, sectionCode, natureDepense, programme, action);
        TypedQuery<LigneDepense> query = em.createQuery(queryString, LigneDepense.class);
        this.setParameters(natureEconomiqueCode, activiteCode, sectionCode, natureDepense, programme, action, query);
        return query.getResultList();
    }

    private String buildQuery(String natureEconomiqueCode, String activiteCode, String sectionCode,
                              String natureDepense, String programme, String action){
        String queryString= baseQuery.concat(" WHERE 1=1");

        if(natureEconomiqueCode!=null && !natureEconomiqueCode.equals(""))
            queryString = queryString.concat(" AND natureEconomiqueCode = :natureEconomiqueCode");

        if(activiteCode!=null && !activiteCode.equals(""))
            queryString = queryString.concat(" AND activiteCode = :activiteCode");

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

    private void setParameters(String natureEconomiqueCode, String activiteCode, String sectionCode,
                               String natureDepense, String programme, String action,
                               TypedQuery<LigneDepense> query){
        if(natureEconomiqueCode!=null && !natureEconomiqueCode.equals(""))
            query.setParameter("natureEconomiqueCode", natureEconomiqueCode);

        if(activiteCode!=null && !activiteCode.equals(""))
            query.setParameter("activiteCode", activiteCode);

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
