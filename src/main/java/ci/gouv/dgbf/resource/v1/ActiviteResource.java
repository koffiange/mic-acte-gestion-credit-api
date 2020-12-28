package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.dto.Activite;
import ci.gouv.dgbf.service.ActiviteService;
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
public class ActiviteResource {
    @Inject
    ActiviteService activiteService;

    @GET
    public List<Activite> findAll(){
        return activiteService.findAll();
    }

    @GET
    @Path("/code/{code}")
    public Activite findByCode(@PathParam("code") String code){
        return activiteService.findByCode(code);
    }
}
