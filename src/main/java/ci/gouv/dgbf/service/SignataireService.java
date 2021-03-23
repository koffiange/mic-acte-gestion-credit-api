package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Acte;
import ci.gouv.dgbf.domain.Signataire;
import ci.gouv.dgbf.domain.Visa;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SignataireService implements PanacheRepositoryBase<Signataire, String> {

    public List<Signataire> findByActe(Acte acte){
        return list("acte.uuid", acte.uuid);
    }

    public void persistAll(List<Signataire> signataireList, Acte acte){
        signataireList.forEach(signataire -> {
            signataire.acte = acte;
            signataire.persist();
        });
    }

    public List<Signataire> update(List<Signataire> signataireList, Acte acte){
        this.deleteByActe(acte);
        this.persistAll(signataireList, acte);
        return signataireList;
    }

    public void deleteAll(List<Signataire> signataires){
        signataires.forEach(PanacheEntityBase::delete);
    }

    public void deleteByActe(Acte acte){
        delete("acte.uuid", acte.uuid);
    }
}
