package ci.gouv.dgbf.service.mea;

import ci.gouv.dgbf.domain.agc.Acte;
import ci.gouv.dgbf.domain.mea.ActeMea;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import io.quarkus.hibernate.orm.PersistenceUnit;
import java.util.logging.Logger;

@ApplicationScoped
public class ActeMeaService {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    @PersistenceUnit("mea")
    EntityManager em;

    public void persist(Acte acte){
        ActeMea acteMea = new ActeMea(acte);
        em.persist(acteMea);
    }
}
