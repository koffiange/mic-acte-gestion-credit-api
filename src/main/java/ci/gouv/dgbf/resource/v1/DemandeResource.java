package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.agc.Demande;
import ci.gouv.dgbf.service.DemandeService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/demandes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Demande", description="Opération relatives aux Demandes")
public class DemandeResource  implements BaseResource<Demande> {
    @Inject
    DemandeService demandeService;

    @GET
    @Override
    public List<Demande> listAll() {
        return demandeService.listAll();
    }

    @GET
    @Path("/demande/{uuid}")
    @Override
    public Demande findById(@PathParam("uuid") String uuid) {
        return demandeService.findById(uuid);
    }

    @POST
    @Path("/demande")
    @Override
    public void persist(Demande demande) {
        demandeService.persist(demande);
    }

    @PUT
    @Path("/demande")
    @Override
    public void update(Demande demande) {
        demandeService.persist(demande);
    }

    @DELETE
    @Path("/demande/{uuid}")
    @Override
    public void delete(@PathParam("uuid") String uuid) {
        demandeService.deleteById(uuid);
    }
}
