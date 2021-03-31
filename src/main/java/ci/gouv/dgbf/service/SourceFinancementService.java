package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.agc.SourceFinancement;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class SourceFinancementService {
    @Inject
    EntityManager em;

    public List<SourceFinancement> listAll(){
        TypedQuery<SourceFinancement> query = em.createQuery("SELECT sf FROM V_SOURCE_FINANCEMENT sf", SourceFinancement.class);
        return query.getResultList();
    }

}
