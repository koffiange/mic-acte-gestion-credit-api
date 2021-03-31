package ci.gouv.dgbf.service.mea;

import ci.gouv.dgbf.domain.agc.Acte;
import ci.gouv.dgbf.domain.agc.Imputation;
import ci.gouv.dgbf.domain.agc.LigneOperation;
import ci.gouv.dgbf.domain.mea.FinancementDepenseMea;
import ci.gouv.dgbf.domain.mea.LigneDepenseMea;
import io.quarkus.hibernate.orm.PersistenceUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class FinancementDepenseMeaService {
    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    @PersistenceUnit("mea")
    EntityManager em;

    public void persistAll(List<LigneOperation> ligneOperationList, Acte acte){
        ligneOperationList.forEach(ligneOperation -> {
            FinancementDepenseMea financementDepenseMea = FinancementDepenseMea.parseLigneOperation(ligneOperation, acte);
            em.persist(financementDepenseMea);
        });
    }
}
