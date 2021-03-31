package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.agc.Exercice;
import ci.gouv.dgbf.service.ExerciceService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("/v1/exercices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Exercice", description="Opération relatives aux exercices")
public class ExerciceResource {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    ExerciceService exerciceService;

    @GET
    @Path("/exercice/courant")
    public Exercice findCurrent() {
        return exerciceService.listAll().get(0);
    }

    @POST
    @Path("/exercice")
    public void persist(Exercice exercice) {
        LOG.info(exercice.toString());
        exerciceService.persist(exercice);
    }

    @PUT
    @Path("/exercice")
    public void update(Exercice exercice) {
        exerciceService.persist(exercice);
    }

}
