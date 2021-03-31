package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.agc.Acte;
import ci.gouv.dgbf.domain.agc.LigneOperation;
import ci.gouv.dgbf.domain.agc.Operation;
import ci.gouv.dgbf.dto.OperationBag;
import ci.gouv.dgbf.enumeration.StatutOperation;
import ci.gouv.dgbf.service.mea.ActeMeaService;
import ci.gouv.dgbf.service.mea.LigneDepenseMeaService;
import ci.gouv.dgbf.service.mea.OperationMeaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class OperationService {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    ActeService acteService;

    @Inject
    SignataireService signataireService;

    @Inject
    LigneOperationService ligneOperationService;

    @Inject
    ImputationService imputationService;

    @Inject
    ActeMeaService acteMeaService;

    @Inject
    OperationMeaService operationMeaService;

    @Inject
    LigneDepenseMeaService ligneDepenseMeaService;



    public List<OperationBag> listAll(){
        List<Operation> operationList = Operation.listAll();
        return operationList.stream().map(this::buildOperationDto).collect(Collectors.toList());
    }

    public Operation findById(String uuid){
        return Operation.findById(uuid);
    }

    public OperationBag findBagById(String uuid){
        OperationBag operationBag = new OperationBag();
        operationBag.operation = Operation.findById(uuid);
        operationBag.acte = acteService.findDefaultActeByOperation(operationBag.operation);
        if(operationBag.acte != null)
            operationBag.signataireList = signataireService.findByActe(operationBag.acte);
        operationBag.ligneOperationList = ligneOperationService.findByOperation(operationBag.operation);
        return operationBag;
    }

    private OperationBag buildOperationDto(Operation operation){
        OperationBag operationBag = new OperationBag();
        operationBag.operation = operation;
        operationBag.acte = acteService.findDefaultActeByOperation(operation);
        if (operationBag.acte != null) {
            operationBag.signataireList = signataireService.findByActe(operationBag.acte);
        }
        operationBag.ligneOperationList = ligneOperationService.findByOperation(operation);
        return operationBag;
    }

    public OperationBag persist(OperationBag operationBag){
        LOG.info("-- OPERATION PERSISTING PROCESS --");
        operationBag.operation.codeOperation = this.generateReferenceProjetActe();
        operationBag.operation.persist();
        LOG.info("OPERATION PERSISTING [OK]");
        Acte acte = acteService.persist(operationBag.acte, operationBag.operation);
        LOG.info(acte.toString());
        LOG.info("ACTE PERSISTING [OK]");
        // signataireService.persistAll(operationBag.signataireList, operationBag.acte);
        imputationService.persistAll(operationBag.imputationDtoList, acte);
        LOG.info("IMPUTATION PERSISTING [OK]");
        ligneOperationService.persistAll(operationBag.ligneOperationList, operationBag.operation);
        LOG.info("LIGNE OPERATION PERSISTING [OK]");
        return operationBag;
    }

    public OperationBag update(OperationBag operationBag){
        operationBag.operation = this.updateOperation(operationBag.operation);
        if (operationBag.operation!=null)
            operationBag.ligneOperationList = ligneOperationService.updateAll(operationBag.ligneOperationList, operationBag.operation);
        operationBag.acte = acteService.update(operationBag.acte);
        operationBag.signataireList = signataireService.update(operationBag.signataireList, operationBag.acte);
        return operationBag;
    }

    public void appliquer(OperationBag operationBag){
        operationBag.operation.statutOperation = StatutOperation.APPLIQUE;
        this.updateOperation(operationBag.operation);
        acteService.appliquer(operationBag);
        this.postApplication(operationBag);
    }

    public void postApplication(OperationBag operationBag){
        acteMeaService.persist(operationBag.acte);
        LOG.info("=> Persist ActeMea OK");
        List<LigneOperation> ligneOperationList = ligneOperationService.findByOperation(operationBag.operation);
        operationMeaService.persistAll(ligneOperationList, operationBag.acte);
        LOG.info("=> Persist OperationMea OK");
    }

    private Operation updateOperation(Operation operation){
        Operation old = Operation.findById(operation.uuid);
        if (old == null)
            return null;

        old.codeOperation = operation.codeOperation;
        old.statutOperation = operation.statutOperation;
        old.variationAE = operation.variationAE;
        old.variationCP = operation.variationCP;
        old.persist();

        return old;
    }

    public void delete(String uuid){
        LOG.info("-- DELETE PROCESS --");
        Operation operation = Operation.findById(uuid);
        Acte acte = acteService.findDefaultActeByOperation(operation);
        LOG.info("=> DEFAULT ACTE FOUND");
        imputationService.deleteByActe(acte.uuid);
        LOG.info("=> IMPUTATION DELETED");
        acte.delete();
        acteService.deleteByOperation(operation);
        LOG.info("=> ACTES DELETED");
        ligneOperationService.deleteByOperation(operation);
        LOG.info("=> LIGNE OPERATION DELETED");
        Operation.deleteById(uuid);
        LOG.info("=> OPERATION DELETED");
    }

    private String generateReferenceProjetActe(){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(LocalDate.now().toString());
        stringBuilder.append("-");
        LOG.info("ReferenceProjetActe, date part : -->"+stringBuilder.toString());
        stringBuilder.append(new Random().nextInt(10000000));
        LOG.info("ReferenceProjetActe, number part : -->"+stringBuilder.toString());
        return stringBuilder.toString();
    }






















    /*
    public List<LigneOperation> findByActe(Acte acte){
        return list("acte.uuid", acte.uuid);
    }

    public void persist(LigneOperation ligneOperation){
        if (ligneOperation.uuid != null){
            LigneOperation old = LigneOperation.findById(ligneOperation.uuid);
            this.update(old, ligneOperation);
        } else {
            ligneOperation.persist();
        }
    }

    public void persistAll(List<LigneOperation> ligneOperationList, OperationMea operation){
        ligneOperationList.forEach(ligneOperation -> {
            ligneOperation.operation = operation;
            operation.persist();
        });
    }


    private void update(LigneOperation old, LigneOperation ligneOperation){
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

    public void deleteByActe(String uuid){
        delete("acte.uuid", uuid);
    }

     */
}
