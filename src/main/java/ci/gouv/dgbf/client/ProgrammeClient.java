package ci.gouv.dgbf.client;

import ci.gouv.dgbf.dto.Programme;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/unites-specialisations-budgetaires")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProgrammeClient {
    @GET
    @Path("/programmes/sections-budgetaires/{uuid}")
    List<Programme> findBySection(@PathParam("uuid") String uuid);

    @GET
    @Path("/code/{uuid}")
    Programme findByCode(@PathParam("uuid") String code);
}
