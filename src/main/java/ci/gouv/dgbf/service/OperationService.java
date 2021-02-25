package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Acte;
import ci.gouv.dgbf.domain.Operation;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OperationService implements PanacheRepositoryBase<Operation, String> {

    public List<Operation> findByActe(Acte acte){
        return list("acte.uuid", acte.uuid);
    }

    public void persist(Operation operation){
        if (operation.uuid != null){
            Operation old = Operation.findById(operation.uuid);
            this.update(old, operation);
        } else {
            operation.persist();
        }
    }

    public void persistAll(List<Operation> operationList, Acte acte){
        operationList.forEach(operation -> {
            operation.acte = acte;
            operation.persist();
        });
    }


    private void update(Operation old, Operation operation){
        old.acte = operation.acte;
        old.activiteCode = operation.activiteCode;
        old.activiteLibelle = operation.activiteLibelle;
        old.budgetActuelAE = operation.budgetActuelAE;
        old.budgetActuelCP = operation.budgetActuelCP;
        old.disponibiliteCredit = operation.disponibiliteCredit;
        old.effetOperation = operation.effetOperation;
        old.exercice = operation.exercice;
        old.sourceFinancementCode = operation.sourceFinancementCode;
        old.sourceFinancementLibelle = operation.sourceFinancementLibelle;
        old.bailleurId = operation.bailleurId;
        old.bailleurLibelle = operation.bailleurLibelle;
        old.ligneDepenseUuid = operation.ligneDepenseUuid;
        old.montantOperationAE = operation.montantOperationAE;
        old.montantOperationCP = operation.montantOperationCP;
        old.typeOperation = operation.typeOperation;
        old.natureEconomiqueLibelle = operation.natureEconomiqueLibelle;
        old.natureEconomiqueCode = operation.natureEconomiqueCode;
        old.persist();
    }

    public void deleteByActe(String uuid){
        delete("acte.uuid", uuid);
    }
}
