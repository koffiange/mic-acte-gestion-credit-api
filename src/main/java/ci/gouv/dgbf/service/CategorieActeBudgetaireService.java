package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.CategorieActeBudgetaire;
import ci.gouv.dgbf.domain.LigneDepense;
import ci.gouv.dgbf.enumeration.CategorieActeUsage;
import ci.gouv.dgbf.enumeration.NatureActe;
import ci.gouv.dgbf.enumeration.TypeActe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class CategorieActeBudgetaireService {
    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    EntityManager em;

    private final String baseQuery="SELECT cab FROM V_CATEGORIE_ACTE_BUDGETAIRE cab ";

    public CategorieActeBudgetaire findById(String uuid){
        String queryString= baseQuery.concat(" WHERE cab.uuid = :uuid");
        TypedQuery<CategorieActeBudgetaire> query = em.createQuery(queryString, CategorieActeBudgetaire.class);
        query.setParameter("uuid", uuid);
        return query.getSingleResult();
    }

    public List<CategorieActeBudgetaire> listAll(){
        TypedQuery<CategorieActeBudgetaire> query = em.createQuery(baseQuery, CategorieActeBudgetaire.class);
        return query.getResultList();
    }

    public List<CategorieActeBudgetaire> findByUsage(CategorieActeUsage usage){
        String queryString= baseQuery.concat(" WHERE cab.usage = :usage");
        TypedQuery<CategorieActeBudgetaire> query = em.createQuery(queryString, CategorieActeBudgetaire.class);
        query.setParameter("usage", usage.name());
        return query.getResultList();
    }

    public List<CategorieActeBudgetaire> findByNatureActe(NatureActe na){
        String queryString= baseQuery.concat(" WHERE cab.natureActe = :na");
        TypedQuery<CategorieActeBudgetaire> query = em.createQuery(queryString, CategorieActeBudgetaire.class);
        query.setParameter("na", na.valeur);
        return query.getResultList();
    }

    public List<CategorieActeBudgetaire> findByTypeActe(TypeActe ta){
        String queryString= baseQuery.concat(" WHERE cab.typeActe = :ta");
        TypedQuery<CategorieActeBudgetaire> query = em.createQuery(queryString, CategorieActeBudgetaire.class);
        query.setParameter("na", ta.name());
        return query.getResultList();
    }
}
