package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Demande;
import ci.gouv.dgbf.domain.Visa;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemandeService implements PanacheRepositoryBase<Demande, String> {
    public void persist(Demande demande){
        if (demande.uuid != null){
            Demande old = Visa.findById(demande.uuid);
            this.update(old, demande);
        } else {
            demande.persist();
        }
    }

    private void update(Demande old, Demande demande){
        old.typeDemande = demande.typeDemande;
        old.contenu = demande.contenu;
        old.demandeurSectionCode = demande.demandeurSectionCode;
        old.demandeurSectionLibelle = demande.demandeurSectionLibelle;
        old.demandeurUaCode = demande.demandeurUaCode;
        old.demandeurUaLibelle = demande.demandeurUaLibelle;
        old.statutDemande = demande.statutDemande;
        old.persist();
    }
}
