package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Acte;
import ci.gouv.dgbf.domain.Demande;
import ci.gouv.dgbf.domain.Signataire;
import ci.gouv.dgbf.domain.Visa;
import ci.gouv.dgbf.dto.ActeDto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ActeService implements PanacheRepositoryBase<Acte, String> {

    @Inject
    SignataireService signataireService;
    @Inject
    OperationService operationService;


    public List<Acte> findByDemande(String uuid){
        return find("demande.uuid", uuid).list();
    }

    public void persist(ActeDto acteDto){
        if (acteDto.acte.uuid != null){
            Acte old = Acte.findById(acteDto.acte.uuid);
            this.update(old, acteDto.acte);
            //
            signataireService.deleteByActe(acteDto.acte.uuid);
            signataireService.persistAll(acteDto.signataireList, acteDto.acte);
            operationService.deleteByActe(acteDto.acte.uuid);
            operationService.persistAll(acteDto.operationList, acteDto.acte);
        } else {
            acteDto.acte.persist();
            signataireService.persistAll(acteDto.signataireList, acteDto.acte);
            operationService.persistAll(acteDto.operationList, acteDto.acte);
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

    public void delete(String uuid){
        deleteById(uuid);
        signataireService.deleteByActe(uuid);
    }
}
