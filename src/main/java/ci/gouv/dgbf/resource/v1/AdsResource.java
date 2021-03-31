package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.agc.ActiviteDeService;
import ci.gouv.dgbf.service.AdsService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/activites-services")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Activités de services", description="Opération relatives aux Activités de services")
public class AdsResource {
    @Inject
    AdsService adsService;

    @GET
    public List<ActiviteDeService> findAll(){
        return adsService.listAll();
    }

    @GET
    @Path("/code/{code}")
    public ActiviteDeService findByCode(@PathParam("code") String code){
        return adsService.findByCode(code);
    }

    @GET
    @Path("/section/{code}")
    public List<ActiviteDeService> findBySectionCode(@PathParam("code") String sectionCode){
        return adsService.findBySectionCode(sectionCode);
    }
}
