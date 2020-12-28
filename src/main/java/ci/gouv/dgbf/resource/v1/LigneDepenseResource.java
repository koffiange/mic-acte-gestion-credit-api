package ci.gouv.dgbf.resource.v1;


import ci.gouv.dgbf.domain.LigneDepense;
import ci.gouv.dgbf.service.LigneDepenseService;
import org.apache.commons.logging.Log;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/v1/lignes-depenses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Operations", description="Opération relatives aux Opérations")
public class LigneDepenseResource{
    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    LigneDepenseService ligneDepenseService;

    @GET
    public List<LigneDepense> findAll(){
        return ligneDepenseService.findAll();
    }

    @GET
    @Path("/nature-economique/{nat_code}")
    public List<LigneDepense> findByCritere(@PathParam("nat_code") String nat_code){
        return ligneDepenseService.findByNatureEconomiqueCode(nat_code);
    }

    @GET
    @Path("/activite/{ads_code}")
    public List<LigneDepense> findByActivite(@PathParam("ads_code") String ads_code){
        return ligneDepenseService.findByActiviteCode(ads_code);
    }

    @GET
    @Path("/section/{secb_code}")
    public List<LigneDepense> findBySection(@PathParam("secb_code") String secb_code){
        return ligneDepenseService.findByActiviteCode(secb_code);
    }

    @GET
    @Path("/criteres")
    public List<LigneDepense> findByCritere(@QueryParam("nat_code") String nat_code,
                                            @QueryParam("ads_code") String ads_code,
                                            @QueryParam("secb_code") String secb_code){
        LOG.info("nat_code : " + nat_code);
        LOG.info("ads_code : " + ads_code);
        LOG.info("secb_code : " + secb_code);
        List<LigneDepense> ligneDepenses = ligneDepenseService.findByCritere(nat_code,ads_code, secb_code);
        LOG.info("NB Ligne : " + ligneDepenses.size());
        return ligneDepenses;
    }
}
