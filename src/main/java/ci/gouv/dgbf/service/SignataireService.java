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

    public List<Signataire> findByActe(String uuid){
        return list("acte.uuid", uuid);
    }

    public void persistAll(List<Signataire> signataires, Acte acte){
        signataires.forEach(signataire -> {
            signataire.acte = acte;
            signataire.persist();
        });
    }

    public void deleteAll(List<Signataire> signataires){
        signataires.forEach(PanacheEntityBase::delete);
    }

    public void deleteByActe(String uuid){
        delete("acte.uuid", uuid);
    }
}
