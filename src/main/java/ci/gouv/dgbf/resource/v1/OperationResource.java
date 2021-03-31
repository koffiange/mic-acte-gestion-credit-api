package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.agc.Operation;
import ci.gouv.dgbf.dto.OperationBag;
import ci.gouv.dgbf.service.OperationService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/operations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Operations", description="Opération relatives aux Opérations")
public class OperationResource {
    @Inject
    OperationService operationService;

    @GET
    public List<OperationBag> listAll() {
        return operationService.listAll();
    }

    @GET
    @Path("/operation/{uuid}")
    public Operation findById(@PathParam("uuid") String uuid) {
        return operationService.findById(uuid);
    }

    @GET
    @Path("/operation/bag/{uuid}")
    public OperationBag findBagById(@PathParam("uuid") String uuid) {
        return operationService.findBagById(uuid);
    }

    @POST
    @Path("/operation")
    public OperationBag persist(OperationBag operationBag) {
        return operationService.persist(operationBag);
    }

    @PUT
    @Path("/operation")
    public OperationBag update(OperationBag operationBag) {
        return operationService.update(operationBag);
    }

    @PUT
    @Path("/operation/appliquer")
    public void appliquer(OperationBag operationBag) {
        operationService.appliquer(operationBag);
    }

    @DELETE
    @Path("/operation/{uuid}")
    public void delete(@PathParam("uuid") String uuid) {
        operationService.delete(uuid);
    }
}
