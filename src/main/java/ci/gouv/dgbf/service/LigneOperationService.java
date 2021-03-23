package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.LigneOperation;
import ci.gouv.dgbf.domain.Operation;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class LigneOperationService implements PanacheRepositoryBase<LigneOperation, String> {
    public List<LigneOperation> findByOperation(Operation operation){
        return list("operation.uuid", operation.uuid);
    }

    public void persist(LigneOperation ligneOperation, Operation operation){
        if (ligneOperation.uuid != null){
            this.update(ligneOperation);
        } else {
            ligneOperation.operation = operation;
            ligneOperation.persist();
        }
    }

    public List<LigneOperation> persistAll(List<LigneOperation> ligneOperationList, Operation operation){
        ligneOperationList.forEach(ligneOperation -> {
            ligneOperation.operation = operation;
            operation.persist();
        });
        return ligneOperationList;
    }

    public void deleteByOperation(Operation operation){
        delete("operation.uuid", operation.uuid);
    }

    public List<LigneOperation> updateAll(List<LigneOperation> ligneOperationList, Operation operation){
        deleteByOperation(operation);
        return persistAll(ligneOperationList, operation);
    }

    private void update(LigneOperation ligneOperation){
        LigneOperation old = LigneOperation.findById(ligneOperation.uuid);
        old.operation = ligneOperation.operation;
        old.usbCode = ligneOperation.usbCode;
        old.usbLibelle = ligneOperation.usbLibelle;
        old.sectionCode = ligneOperation.sectionCode;
        old.sectionLibelle = ligneOperation.sectionLibelle;
        old.activiteCode = ligneOperation.activiteCode;
        old.activiteLibelle = ligneOperation.activiteLibelle;
        old.budgetActuelAE = ligneOperation.budgetActuelAE;
        old.budgetActuelCP = ligneOperation.budgetActuelCP;
        old.disponibiliteCredit = ligneOperation.disponibiliteCredit;
        old.effetOperation = ligneOperation.effetOperation;
        old.exercice = ligneOperation.exercice;
        old.sourceFinancementCode = ligneOperation.sourceFinancementCode;
        old.sourceFinancementLibelle = ligneOperation.sourceFinancementLibelle;
        old.bailleurCode = ligneOperation.bailleurCode;
        old.bailleurLibelle = ligneOperation.bailleurLibelle;
        old.ligneDepenseUuid = ligneOperation.ligneDepenseUuid;
        old.montantOperationAE = ligneOperation.montantOperationAE;
        old.montantOperationCP = ligneOperation.montantOperationCP;
        old.montantDisponibleAE = ligneOperation.montantDisponibleAE;
        old.montantDisponibleCP = ligneOperation.montantDisponibleCP;
        old.disponibleRestantAE = ligneOperation.disponibleRestantAE;
        old.disponibleRestantCP = ligneOperation.disponibleRestantCP;
        old.typeOperation = ligneOperation.typeOperation;
        old.natureEconomiqueLibelle = ligneOperation.natureEconomiqueLibelle;
        old.natureEconomiqueCode = ligneOperation.natureEconomiqueCode;
        old.persist();
    }


}
