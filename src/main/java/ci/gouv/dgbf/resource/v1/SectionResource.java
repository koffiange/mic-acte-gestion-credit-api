package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.client.SectionClient;
import ci.gouv.dgbf.dto.Section;
import ci.gouv.dgbf.service.SectionService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/v1/sections")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class SectionResource {

    Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    @RestClient
    SectionClient sectionClient;

    @Inject
    SectionService sectionService;
    @GET
    public List<Section> list(){
        return sectionService.findAll();
    }

    @GET
    @Path("/code/{code}")
    public Section findByCode(@PathParam("code") String code){
        return sectionClient.findByCode(code);
    }

    @GET
    @Path("/filtre/type/{type}")
    public List<Section> filteredByType(@PathParam("type") String type){
        return sectionClient.filteredByType(type);
    }


}
