package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Acte;
import ci.gouv.dgbf.domain.Operation;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class OperationService implements PanacheRepositoryBase<Operation, String> {

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
        old.sourceFinancement = operation.sourceFinancement;
        old.ligneDepenseUuid = operation.ligneDepenseUuid;
        old.montantOperationAE = operation.montantOperationAE;
        old.montantOperationCP = operation.montantOperationCP;
        old.typeOperation = operation.typeOperation;
        old.natureEconomique = operation.natureEconomique;
        old.natureEconomiqueCode = operation.natureEconomiqueCode;
        old.persist();
    }

    public void deleteByActe(String uuid){
        delete("acte.uuid", uuid);
    }
}
