package ci.gouv.dgbf.client;

import ci.gouv.dgbf.dto.NatureEcnomique;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/natures-economiques")
public interface NatureEconomiqueClient {
    @GET
    public List<NatureEcnomique> findAll();

    @GET
    @Path("/codes/{code}")
    NatureEcnomique findByCode(@PathParam("code") String code);

    @GET
    @Path("/{uuid}")
    NatureEcnomique findByUuid(@PathParam("uuid") String uuid);
}
