package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.*;
import ci.gouv.dgbf.dto.ActeDto;
import ci.gouv.dgbf.enumeration.StatutActe;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@ApplicationScoped
public class ActeService implements PanacheRepositoryBase<Acte, String> {

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


    public List<Acte> findByDemande(String uuid){
        return find("demande.uuid", uuid).list();
    }

    public ActeDto findActeDtoById(String uuid) {
        ActeDto acteDto = new ActeDto();

        acteDto.acte = Acte.findById(uuid);
        // acteDto.imputationList = imputationService.findByActe(acteDto.acte);
        acteDto.operationList = operationService.findByActe(acteDto.acte);
        acteDto.signataireList = signataireService.findByActe(acteDto.acte.uuid);

        return acteDto;
    }

    public Acte persist(ActeDto acteDto){
        if (acteDto.acte.uuid != null){
            Acte old = Acte.findById(acteDto.acte.uuid);
            this.update(old, acteDto.acte);
            imputationService.deleteByActe(acteDto.acte.uuid);
            if (!acteDto.imputationDtoList.isEmpty())
                imputationService.persistAll(acteDto.imputationDtoList, acteDto.acte);
            operationService.deleteByActe(acteDto.acte.uuid);
            operationService.persistAll(acteDto.operationList, acteDto.acte);
        } else {
            acteDto.acte.persist();
            if (!acteDto.imputationDtoList.isEmpty())
                imputationService.persistAll(acteDto.imputationDtoList, acteDto.acte);
            operationService.persistAll(acteDto.operationList, acteDto.acte);
        }
        return Acte.findById(acteDto.acte.uuid);
    }




    public void persist_old(ActeDto acteDto){
        if (acteDto.acte.uuid != null){
            Acte old = Acte.findById(acteDto.acte.uuid);
            this.update(old, acteDto.acte);

            signataireService.deleteByActe(acteDto.acte.uuid);
            signataireService.persistAll(acteDto.signataireList, acteDto.acte);
            operationService.deleteByActe(acteDto.acte.uuid);
            operationService.persistAll(acteDto.operationList, acteDto.acte);
            reservationService.deleteByActe(acteDto.acte.uuid);
        } else {
            acteDto.acte.persist();
            signataireService.persistAll(acteDto.signataireList, acteDto.acte);
            operationService.persistAll(acteDto.operationList, acteDto.acte);
            reservationService.persistReservationOfOperation(acteDto.operationList);
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

    public boolean checkReferenceAlreadyExist(String reference){
        return !Acte.find("reference", reference).list().isEmpty();
    }
}
