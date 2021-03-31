package ci.gouv.dgbf.service.mea;

import ci.gouv.dgbf.domain.agc.Acte;
import ci.gouv.dgbf.domain.agc.LigneOperation;
import ci.gouv.dgbf.domain.mea.LigneDepenseMea;
import ci.gouv.dgbf.domain.mea.OperationMea;
import io.quarkus.hibernate.orm.PersistenceUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class OperationMeaService {
    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    @PersistenceUnit("mea")
    EntityManager em;

    public void persistAll(List<LigneOperation> ligneOperationList, Acte acte){
        if (ligneOperationList.isEmpty())
            LOG.info("La liste des operations est vide.");
        ligneOperationList.forEach(ligneOperation -> {
            OperationMea operationMea = new OperationMea(ligneOperation, acte);
            em.persist(operationMea);
            LOG.info("= = = OPERATION "+operationMea.acteId+" persisted");
        });
    }
}
