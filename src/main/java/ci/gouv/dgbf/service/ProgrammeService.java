package ci.gouv.dgbf.service;

import ci.gouv.dgbf.client.ProgrammeClient;
import ci.gouv.dgbf.client.SectionClient;
import ci.gouv.dgbf.dto.Programme;
import ci.gouv.dgbf.dto.Section;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ProgrammeService{

    Logger LOG = Logger.getLogger(this.getClass().getName());
    @Inject @RestClient
    ProgrammeClient client;

    public List<Programme> findBySection(String uuid) {
        return client.findBySection(uuid);
    }

    public Programme findByCode(String code) {
        return client.findByCode(code);
    }
}


