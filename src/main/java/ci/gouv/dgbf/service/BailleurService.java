package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.agc.Bailleur;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class BailleurService {
    @Inject
    EntityManager em;

    public List<Bailleur> listAll(){
        TypedQuery<Bailleur> query = em.createQuery("SELECT b FROM V_BAILLEUR b", Bailleur.class);
        return query.getResultList();
    }
}
