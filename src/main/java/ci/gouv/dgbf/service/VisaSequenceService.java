package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.agc.VisaSequence;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VisaSequenceService implements PanacheRepositoryBase<VisaSequence, String> {


    public void init(){
        VisaSequence visaSequence = new VisaSequence();
        visaSequence.persist();
    }

    public VisaSequence retrieveSequence(){
        return VisaSequence.findAll().firstResult();
    }

    public void incremente(VisaSequence visaSequence){
        visaSequence.sequence += 1;
        visaSequence.persist();
    }
}
