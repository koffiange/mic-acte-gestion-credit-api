package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Visa;
import ci.gouv.dgbf.domain.VisaSequence;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class VisaService implements PanacheRepositoryBase<Visa, String> {
    @Inject
    VisaSequenceService visaSequenceService;

    public void persist(Visa visa){
        VisaSequence seq = visaSequenceService.retrieveSequence();
        if (visa.uuid != null){
            Visa old = Visa.findById(visa.uuid);
            this.update(old, visa);
        } else {
            visa.code = "VISA"+seq.sequence;
            visa.persist();
            visaSequenceService.incremente(visaSequenceService.retrieveSequence());
        }

    }

    private void update(Visa old, Visa visa){
        // old.code = visa.code;
        old.intitule = visa.intitule;
        old.persist();
    }
}
