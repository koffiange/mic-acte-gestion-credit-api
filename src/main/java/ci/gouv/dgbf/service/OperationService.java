package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Demande;
import ci.gouv.dgbf.domain.Operation;
import ci.gouv.dgbf.domain.Visa;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

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

    private void update(Operation old, Operation operation){
        old.acte = operation.acte;
        old.activiteCode = operation.activiteCode;
        old.activiteLibelle = operation.activiteLibelle;
        old.budgetActuelAE = operation.budgetActuelAE;
        old.budgetActuelCP = operation.budgetActuelCP;
        old.disponibiliteCredit = operation.disponibiliteCredit;
        old.effetOperation = operation.effetOperation;
        old.exercice = operation.exercice;
        old.ligneDepenseUuid = operation.ligneDepenseUuid;
        old.montantOperationAE = operation.montantOperationAE;
        old.montantOperationCP = operation.montantOperationCP;
        old.natureEconomique = operation.natureEconomique;
        old.natureEconomiqueCode = operation.natureEconomiqueCode;
        old.persist();
    }
}
