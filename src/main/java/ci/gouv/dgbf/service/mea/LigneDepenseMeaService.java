package ci.gouv.dgbf.service.mea;

import ci.gouv.dgbf.domain.agc.Acte;
import ci.gouv.dgbf.domain.agc.LigneOperation;
import ci.gouv.dgbf.domain.agc.Operation;
import ci.gouv.dgbf.domain.mea.LigneDepenseMea;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import io.quarkus.hibernate.orm.PersistenceUnit;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class LigneDepenseMeaService {
    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    @PersistenceUnit("mea")
    EntityManager em;

    public void persistAll(List<LigneOperation> ligneOperationList, Acte acte){
        ligneOperationList.forEach(ligneOperation -> {
            LigneDepenseMea ligneDepenseMea = new LigneDepenseMea(ligneOperation, acte);
            em.persist(ligneDepenseMea);
        });
    }
}
