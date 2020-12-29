package ci.gouv.dgbf.service;

import ci.gouv.dgbf.client.SectionClient;
import ci.gouv.dgbf.dto.Section;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class SectionService {

    Logger LOG = Logger.getLogger(this.getClass().getName());
    @Inject
    @RestClient
    SectionClient sectionClient;

    public List<Section> findAll(){
        return sectionClient.listForActiveGouvernement();
    }

    public Section findById(String code){
        return sectionClient.findByCode(code);
    }

    public  List<Section> filteredByType(String type){
        return sectionClient.filteredByType(type);
    }
}


