package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.Bailleur;
import ci.gouv.dgbf.service.BailleurService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/bailleurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Bailleurs", description="Opération relatives aux bailleurs")
public class BailleurResource {
    @Inject
    BailleurService bailleurService;

    @GET
    public List<Bailleur> listAll(){
        return bailleurService.listAll();
    }
}
