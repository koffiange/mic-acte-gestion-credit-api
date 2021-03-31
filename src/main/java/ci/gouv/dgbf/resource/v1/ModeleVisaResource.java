package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.agc.ModeleVisa;
import ci.gouv.dgbf.dto.ModeleVisaDto;
import ci.gouv.dgbf.service.ModeleVisaService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/modeles-visas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="ModeleVisa", description="Opération relatives aux Modeles de Visa")
public class ModeleVisaResource implements BaseResource<ModeleVisa> {

    @Inject
    ModeleVisaService modeleVisaService;

    @GET
    @Override
    public List<ModeleVisa> listAll() {
        return modeleVisaService.listAll();
    }

    @GET
    @Path("/modele/{uuid}")
    @Override
    public ModeleVisa findById(@PathParam("uuid") String uuid) {
        return modeleVisaService.findById(uuid);
    }

    @POST
    @Path("/modele")
    @Override
    public void persist(ModeleVisa modeleVisa) {
        modeleVisaService.persist(modeleVisa);
    }

    @Override
    public void update(ModeleVisa modeleVisa) {

    }

    @POST
    @Path("/modele/compose")
    public void persist(ModeleVisaDto modeleVisaDto) {
        modeleVisaService.persist(modeleVisaDto);
    }

    @PUT
    @Path("/modele")
    public void update(ModeleVisaDto modeleVisaDto) {
        modeleVisaService.persist(modeleVisaDto);
    }

    @DELETE
    @Path("/modele/{uuid}")
    @Override
    public void delete(@PathParam("uuid") String uuid) {
        modeleVisaService.delete(uuid);
    }
}
