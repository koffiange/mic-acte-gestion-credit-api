package ci.gouv.dgbf.client;

import ci.gouv.dgbf.dto.Activite;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/v1/activites-services")
public interface ActiviteClient {
    @GET
    List<Activite> findAll();

    @GET
    @Path("/code/{code}")
    Activite findByCode(@PathParam("code") String code);
}
