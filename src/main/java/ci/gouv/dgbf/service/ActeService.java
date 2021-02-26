package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.*;
import ci.gouv.dgbf.dto.ActeDto;
import ci.gouv.dgbf.enumeration.StatutActe;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import java.util.List;

@ApplicationScoped
public class ActeService implements PanacheRepositoryBase<Acte, String> {

    @Inject
    SignataireService signataireService;
    @Inject
    OperationService operationService;
    @Inject
    ReservationService reservationService;


    public List<Acte> findByDemande(String uuid){
        return find("demande.uuid", uuid).list();
    }

    public ActeDto findActeDtoById(String uuid) {
        ActeDto acteDto = new ActeDto();

        acteDto.acte = Acte.findById(uuid);
        acteDto.operationList = operationService.findByActe(acteDto.acte);
        acteDto.signataireList = signataireService.findByActe(acteDto.acte.uuid);

        return acteDto;
    }

    public void persist(ActeDto acteDto){
        if (acteDto.acte.uuid != null){
            Acte old = Acte.findById(acteDto.acte.uuid);
            this.update(old, acteDto.acte);
            operationService.deleteByActe(acteDto.acte.uuid);
            operationService.persistAll(acteDto.operationList, acteDto.acte);
        } else {
            acteDto.acte.persist();
            operationService.persistAll(acteDto.operationList, acteDto.acte);
        }
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
        uuidList.forEach(this::appliquer);
    }

    public void appliquer(String uuid){
        Acte acte = Acte.findById(uuid);
        if (acte != null){
            /*
            Application des opérations dans un try and catch.
            Si la procedure de passe bien, l'acte passera au satur appliqué.
            Si non, il passera au statut échoué et la cause devra etre précisée.
            */

            // Déreservation des crédits
            List<Operation> operationList = operationService.findByActe(acte);
            reservationService.dereserverParOperation(operationList);
            // Changement de statut de
            acte.statutActe = StatutActe.APPLIQUE;
        }
    }

    public void delete(String uuid){
        signataireService.deleteByActe(uuid);
        operationService.deleteByActe(uuid);
        reservationService.deleteByActe(uuid);
        deleteById(uuid);
    }

    public boolean checkReferenceAlreadyExist(String reference){
        return !Acte.find("reference", reference).list().isEmpty();
    }
}
