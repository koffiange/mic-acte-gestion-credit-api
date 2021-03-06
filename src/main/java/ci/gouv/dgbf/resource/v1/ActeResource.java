package ci.gouv.dgbf.resource.v1;
import ci.gouv.dgbf.domain.agc.Acte;
import ci.gouv.dgbf.service.ActeService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/v1/actes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Actes", description="Opération relatives aux Actes")
public class ActeResource implements BaseResource<Acte>{
    private final Logger LOG = Logger.getLogger(this.getClass().getName());
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

    @Override
    public void update(Acte acte) {
    }

    @GET
    @Path("/operation/{uuid}")
    public List<Acte> findActeByOperation(@PathParam("uuid") String uuid){
        return acteService.findByOperation(uuid);
    }

    /*
    @POST
    @Path("/acte")
    public Acte persist(OperationBag operationDto){
        LOG.info("DTO RECEIVED");
        LOG.info(operationDto.toString());
        return acteService.persist(operationDto);
    }


    @PUT
    @Path("/acte/dto/")
    public Acte update(OperationBag operationDto){
        return acteService.persist(operationDto);
    }

    @PUT
    @Path("/acte/appliquer/{uuid}")
    public void appliquer(@PathParam("uuid") String uuid) {
        Acte acte = Acte.findById(uuid);
        acteService.appliquer(acte);
    }


    @PUT
    @Path("/acte/appliquer/plusieurs")
    public void appliquer(List<String> uuidList) {
        acteService.appliquerPlusieur(uuidList);
    }
     */

    @DELETE
    @Path("/acte/{uuid}")
    @Override
    public void delete(@PathParam("uuid") String uuid) {
        acteService.delete(uuid);
    }

    @GET
    @Path("/acte/check-reference-already-exist")
    public boolean checkReferenceAlreadyExist(@QueryParam("reference") String reference){
        return acteService.checkReferenceAlreadyExist(reference);
    }
}
