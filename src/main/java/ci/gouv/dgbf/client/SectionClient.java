package ci.gouv.dgbf.client;

import ci.gouv.dgbf.dto.Section;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/sections-budgetaires")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SectionClient {

    @GET
    @Path("/active-gouvernement")//à Utiliser
    List<Section> listForActiveGouvernement();

    @GET
    @Path("/code/{code}")
    Section findByCode(@PathParam("code") String code);

    @GET
    @Path("/filtered-by/type/{type}")
    List<Section> filteredByType(@PathParam("type") String type);
}
