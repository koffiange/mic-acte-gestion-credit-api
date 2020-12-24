package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.Operation;
import ci.gouv.dgbf.service.OperationService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.annotations.Pos;

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
public class OperationResource implements BaseResource<Operation> {
    @Inject
    OperationService operationService;

    @GET
    @Override
    public List<Operation> listAll() {
        return operationService.listAll();
    }

    @GET
    @Path("/operation/{uuid}")
    @Override
    public Operation findById(@PathParam("uuid") String uuid) {
        return operationService.findById(uuid);
    }

    @POST
    @Path("/operation")
    @Override
    public void persist(Operation operation) {
        operationService.persist(operation);
    }

    @PUT
    @Path("/operation")
    @Override
    public void update(Operation operation) {
        operationService.persist(operation);
    }

    @DELETE
    @Path("/operation/{uuid}")
    @Override
    public void delete(@PathParam("uuid") String uuid) {
        operationService.deleteById(uuid);
    }
}
