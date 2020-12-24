package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Acte;
import ci.gouv.dgbf.domain.Demande;
import ci.gouv.dgbf.domain.Visa;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ActeService implements PanacheRepositoryBase<Acte, String> {
    public List<Acte> findByDemande(String uuid){
        return find("demande.uuid", uuid).list();
    }

    public void persist(Acte acte){
        if (acte.uuid != null){
            Acte old = Acte.findById(acte.uuid);
            this.update(old, acte);
        } else {
            acte.persist();
        }
    }

    private void update(Acte old, Acte acte){
        old.corpus = acte.corpus;
        old.categorieActe = acte.categorieActe;
        old.dateSignature = acte.dateSignature;
        old.demande = acte.demande;
        old.natureActe = acte.natureActe;
        old.reference = acte.reference;
        old.persist();
    }
}
