package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.*;
import ci.gouv.dgbf.enumeration.ActeRole;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@ApplicationScoped
public class ActeService implements PanacheRepositoryBase<Acte, String> {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    SignataireService signataireService;
    @Inject
    OperationService operationService;
    @Inject
    ImputationService imputationService;
    @Inject
    ReservationService reservationService;
    @Inject
    EntityManager em;

    public List<Acte> findByOperation(Operation operation){
        return Acte.find("operation.uuid", operation.uuid).list();
    }

    public Acte findDefaultActeByOperation(Operation operation){
        Map<String, Object> params = new HashMap<>();
        params.put("uuid", operation.uuid);
        params.put("default", ActeRole.PAR_DEFAUT);
        try {
            return Acte.find("operation.uuid = :uuid AND acteParDefaut = :default", params).singleResult();
        } catch (Exception exception){
            LOG.info("Exception !! "+exception.getMessage());
            return null;
        }
    }

    public Acte persist(Acte acte, Operation operation){
        acte.operation = operation;
        acte.acteParDefaut = (this.findDefaultActeByOperation(operation) == null) ? ActeRole.PAR_DEFAUT : ActeRole.NON_SPECIFIE;
        acte.persist();
        return acte;
    }

    public Acte update(Acte acte){
        Acte old = findById(acte.uuid);
        old.reference = acte.reference;
        old.categorieActe = acte.categorieActe;
        old.natureActe = acte.natureActe;
        old.natureTransaction = acte.natureTransaction;
        old.dateSignature = acte.dateSignature;
        old.cumulRetranchementAE = acte.cumulRetranchementAE;
        old.cumulRetranchementCP = acte.cumulRetranchementCP;
        old.cumulAjoutAE = acte.cumulAjoutAE;
        old.cumulAjoutCP = acte.cumulAjoutCP;
        old.acteParDefaut = acte.acteParDefaut;
        old.statutActe = acte.statutActe;
        old.persist();
        return old;
    }

    public void deleteByOperation(Operation operation){
        List<Acte> acteList = this.findByOperation(operation);
        acteList.forEach(acte -> signataireService.deleteByActe(acte));
        Acte.delete("operation.uuid", operation.uuid);
    }

    public void delete(String uuid){
        Acte.delete("uuid", uuid);
    }

    public boolean checkReferenceAlreadyExist(String reference){
        return !Acte.find("reference", reference).list().isEmpty();
    }
































    /*
    public List<Acte> findByDemande(String uuid){
        return find("demande.uuid", uuid).list();
    }

    public OperationBag findActeDtoById(String uuid) {
        OperationBag acteDto = new OperationBag();

        acteDto.acte = Acte.findById(uuid);
        // acteDto.imputationList = imputationService.findByActe(acteDto.acte);
        acteDto.ligneOperationList = operationService.findByActe(acteDto.acte);
        acteDto.signataireList = signataireService.findByActe(acteDto.acte.uuid);

        return acteDto;
    }

    public Acte persist(OperationBag acteDto){
        if (acteDto.acte.uuid != null){
            Acte old = Acte.findById(acteDto.acte.uuid);
            this.update(old, acteDto.acte);
            imputationService.deleteByActe(acteDto.acte.uuid);
            if (!acteDto.imputationDtoList.isEmpty())
                imputationService.persistAll(acteDto.imputationDtoList, acteDto.acte);
            operationService.deleteByActe(acteDto.acte.uuid);
            operationService.persistAll(acteDto.ligneOperationList, acteDto.acte);
        } else {
            acteDto.acte.referenceProjetActe = this.generateReferenceProjetActe();
            acteDto.acte.persist();
            if (!acteDto.imputationDtoList.isEmpty())
                imputationService.persistAll(acteDto.imputationDtoList, acteDto.acte);
            operationService.persistAll(acteDto.ligneOperationList, acteDto.acte);
        }
        return Acte.findById(acteDto.acte.uuid);
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

    public void persist_old(OperationBag acteDto){
        if (acteDto.acte.uuid != null){
            Acte old = Acte.findById(acteDto.acte.uuid);
            this.update(old, acteDto.acte);

            signataireService.deleteByActe(acteDto.acte.uuid);
            signataireService.persistAll(acteDto.signataireList, acteDto.acte);
            operationService.deleteByActe(acteDto.acte.uuid);
            operationService.persistAll(acteDto.ligneOperationList, acteDto.acte);
            reservationService.deleteByActe(acteDto.acte.uuid);
        } else {
            acteDto.acte.persist();
            signataireService.persistAll(acteDto.signataireList, acteDto.acte);
            operationService.persistAll(acteDto.ligneOperationList, acteDto.acte);
            reservationService.persistReservationOfOperation(acteDto.ligneOperationList);
        }
    }

    private void update(Acte old, Acte acte){
        old.corpus = acte.corpus;
        old.categorieActe = acte.categorieActe;
        old.dateSignature = acte.dateSignature;
        old.demande = acte.demande;
        old.natureActe = acte.natureActe;
        old.natureTransaction = acte.natureTransaction;
        old.reference = acte.reference;
        old.cumulRetranchementAE = acte.cumulRetranchementAE;
        old.cumulRetranchementCP = acte.cumulRetranchementCP;
        old.cumulAjoutAE = acte.cumulAjoutAE;
        old.cumulAjoutCP = acte.cumulAjoutCP;
        old.persist();
    }

    public void appliquerPlusieur(List<String> uuidList){
        uuidList.forEach(s -> {
            Acte acte = Acte.findById(s);
            this.appliquer(acte);
        });
    }


    public void appliquer(Acte acte){
        if (acte != null){
            // Application de l'acte.
            this.appliquerActe(acte.uuid);
            // Changement de statut de l'acte
            acte.statutActe = StatutActe.APPLIQUE;
        }
    }

    public void appliquerActe(String uuid){
        StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("acte.copyIntoBIDF");
        storedProcedureQuery.setParameter("ACTE_ID", uuid);
        storedProcedureQuery.execute();
    }

    public void delete(String uuid){
        imputationService.deleteByActe(uuid);
        operationService.deleteByActe(uuid);
        reservationService.deleteByActe(uuid);
        deleteById(uuid);
    }

     */
}
