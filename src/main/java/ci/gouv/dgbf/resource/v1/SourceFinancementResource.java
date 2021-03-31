package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.agc.SourceFinancement;
import ci.gouv.dgbf.service.SourceFinancementService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/sources-financement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Sources de financement", description="Opération relatives aux Sources de financement")
public class SourceFinancementResource {
    @Inject
    SourceFinancementService sourceFinancementService;

    @GET
    public List<SourceFinancement> listAll(){
        return sourceFinancementService.listAll();
    }
}
