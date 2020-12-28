package ci.gouv.dgbf.resource.v1;
import ci.gouv.dgbf.domain.Acte;
import ci.gouv.dgbf.dto.ActeDto;
import ci.gouv.dgbf.service.ActeService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/actes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Actes", description="Opération relatives aux Actes")
public class ActeResource implements BaseResource<Acte>{
    @Inject
    ActeService acteService;

    @GET
    @Override
    public List<Acte> listAll() {
        return acteService.listAll();
    }

    @GET
    @Path("/acte/{uuid}")
    @Override
    public Acte findById(@PathParam("uuid") String uuid) {
        return acteService.findById(uuid);
    }

    @Override
    public void persist(Acte acte) {

    }

    @POST
    @Path("/acte")
    public void persist(ActeDto acteDto) {
        acteService.persist(acteDto);
    }

    @PUT
    @Path("/acte")
    @Override
    public void update(Acte acte) {
        acteService.persist(acte);
    }

    @DELETE
    @Path("/acte/{uuid}")
    @Override
    public void delete(@PathParam("uuid") String uuid) {
        acteService.deleteById(uuid);
    }
}
