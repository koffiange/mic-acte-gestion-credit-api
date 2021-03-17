package ci.gouv.dgbf.resource.v1;


import ci.gouv.dgbf.dto.NatureEconomique;
import ci.gouv.dgbf.service.NatureEconomiqueService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/natures-economiques")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Nature Economique", description="Opération relatives aux Natures Economiques")
public class NatureEconomiqueResource {
    @Inject
    NatureEconomiqueService natureEconomiqueService;

    @GET
    public List<NatureEconomique> findAll() {
        return natureEconomiqueService.findAll();
    }

    @GET
    @Path("/codes/{code}")
    public NatureEconomique findByCode(@PathParam("code") String code) {
        return natureEconomiqueService.findByCode(code);
    }

    @GET
    @Path("/{uuid}")
    public NatureEconomique findByUuid(@PathParam("uuid") String uuid) {
        return natureEconomiqueService.findByUuid(uuid);
    }

}
