package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.Composition;
import ci.gouv.dgbf.domain.ModeleVisa;
import ci.gouv.dgbf.dto.VisaDto;
import ci.gouv.dgbf.service.CompositionVisaService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/compositions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Composition", description="Opération relatives aux Composition des visas des modele de visa")
public class CompositionVisaResource {
    @Inject
    CompositionVisaService compositionVisaService;

    @GET
    @Path("/modele-visa/{uuid}")
    public List<Composition> findByModele(@PathParam("uuid") String uuid){
        return compositionVisaService.findByModele(uuid);
    }

    @POST
    @Path("/modele-visa/")
    public void persist(ModeleVisa modeleVisa, List<VisaDto> visaList){
        compositionVisaService.persist(modeleVisa, visaList);
    }

    @DELETE
    @Path("/{uuid}")
    public void delete(@PathParam("uuid") String uuid){
        compositionVisaService.deleteById(uuid);
    }
}
