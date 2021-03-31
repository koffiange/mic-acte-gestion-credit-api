package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.agc.Visa;
import ci.gouv.dgbf.service.VisaService;
import io.quarkus.panache.common.Sort;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/visas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Visa", description="Opération relatives aux Visas")
public class VisaResource implements BaseResource<Visa> {

    @Inject
    VisaService visaService;

    @GET
    @Override
    public List<Visa> listAll() {
        return visaService.listAll(Sort.ascending("code"));
    }

    @GET
    @Path("/visa/{uuid}")
    @Override
    public Visa findById(@PathParam("uuid") String uuid) {
        return visaService.findById(uuid);
    }

    @POST
    @Path("/visa")
    @Override
    public void persist(Visa visa) {
        visaService.persist(visa);
    }

    @PUT
    @Path("/visa")
    @Override
    public void update(Visa visa) {
        visaService.persist(visa);
    }

    @DELETE
    @Path("/visa/{uuid}")
    @Override
    public void delete(@PathParam("uuid") String uuid) {
        visaService.deleteById(uuid);
    }
}
