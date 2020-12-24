package ci.gouv.dgbf.service;

import ci.gouv.dgbf.dto.LigneDepense;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class LigneDepenseService {
    @Inject
    EntityManager em;

    private final String baseQuery="SELECT \n" +
            "l.ldep_id as ligneDepenseId,\n" +
            "l.exo_num as exercice,\n" +
            "l.ads_id as activiteId,\n" +
            "l.nat_id as natureEconomiqueId,\n" +
            "nat.nat_code as natureEconomiqueCode,\n" +
            "nat.nat_liblg as natureEconomiqueLibelle,\n" +
            "ads.ads_code as activiteCode,\n" +
            "ads.ads_liblg as activiteLibelle,\n" +
            "l.usb_id as usbId,\n" +
            "l.secb_id as sectionId,\n" +
            "secb.secb_libelle as sectionLibelle,\n" +
            "secb.secb_code as sectionCode,\n" +
            "l.ua_id as uaId,\n" +
            "f.find_id as financementId,\n" +
            "f.find_montant_ae as montantAe,\n" +
            "f.find_montant_cp as montantCP\n" +
            "FROM LIGNE_DE_DEPENSES@DBLINK_ELABO_BIDF l\n" +
            "LEFT JOIN FINANCEMENT_DEPENSES@DBLINK_ELABO_BIDF f ON (f.ldep_id = l.ldep_id)\n" +
            "LEFT JOIN NEC.NATURE_ECONOMIQUES24 nat ON (nat.uuid = l.nat_id)\n" +
            "LEFT JOIN CA.SECTION_BUDGETAIRE secb ON (secb.uuid = l.secb_id)\n" +
            "LEFT JOIN ADS.ACTIVITE_DE_SERVICE ads ON (ads.ads_id = l.ads_id)";

    public List<LigneDepense> findAll(){
        TypedQuery<LigneDepense> query = em.createQuery(baseQuery, LigneDepense.class);
        return query.getResultList();
    }

    public List<LigneDepense> findByActiviteCode(String ads_code){
        String queryString= baseQuery.concat(" WHERE ads.ads_code = :ads_code");

        TypedQuery<LigneDepense> query = em.createQuery(queryString, LigneDepense.class);
        query.setParameter("ads_code", ads_code);
        return query.getResultList();
    }

    public List<LigneDepense> findByNatureEconomiqueCode(String nat_code){
        String queryString= baseQuery.concat(" WHERE nat.nat_code = :nat_code");

        TypedQuery<LigneDepense> query = em.createQuery(queryString, LigneDepense.class);
        query.setParameter("nat_code", nat_code);
        return query.getResultList();
    }


    public List<LigneDepense> findByCritere(String nat_code, String ads_code, String secb_code){
        String queryString= this.buildQuery(nat_code, ads_code, secb_code);
        TypedQuery<LigneDepense> query = em.createQuery(queryString, LigneDepense.class);
        this.setParameters(nat_code, ads_code, secb_code, query);
        return query.getResultList();
    }

    private String buildQuery(String nat_code, String ads_code, String secb_code){
        String queryString= baseQuery.concat(" WHERE 1=1 ");

        if(nat_code!=null)
            queryString = queryString.concat("AND nat.nat_code = :nat_code");

        if(ads_code!=null)
            queryString = queryString.concat("AND ads.ads_code = :ads_code");

        if(secb_code!=null)
            queryString = queryString.concat("AND secb.secb_code = :secb_code");

        return queryString;
    }

    private void setParameters(String nat_code, String ads_code, String secb_code, TypedQuery<LigneDepense> query){
        if(nat_code!=null)
            query.setParameter("nat_code", nat_code);

        if(ads_code!=null)
            query.setParameter("ads_code", ads_code);

        if(secb_code!=null)
            query.setParameter("secb_code", secb_code);
    }
}
