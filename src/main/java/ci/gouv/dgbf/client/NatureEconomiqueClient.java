package ci.gouv.dgbf.client;

import ci.gouv.dgbf.dto.NatureEconomique;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/natures-economiques")
public interface NatureEconomiqueClient {
    @GET
    public List<NatureEconomique> findAll();

    @GET
    @Path("/codes/{code}")
    NatureEconomique findByCode(@PathParam("code") String code);

    @GET
    @Path("/{uuid}")
    NatureEconomique findByUuid(@PathParam("uuid") String uuid);
}
