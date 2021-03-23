package ci.gouv.dgbf.resource.v1;


import ci.gouv.dgbf.domain.LigneDepense;
import ci.gouv.dgbf.domain.LigneOperation;
import ci.gouv.dgbf.service.LigneDepenseService;
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
@Tag(name="Lignes de dépenses", description="Opération relatives aux Lignes de dépense")
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
    public List<LigneDepense> findByCritere(@QueryParam("exercice") String exercice,
                                            @QueryParam("sourceFinancement") String sourceFinancement,
                                            @QueryParam("natureEconomiqueCode") String natureEconomiqueCode,
                                            @QueryParam("activiteCode") String activiteCode,
                                            @QueryParam("bailleur") String bailleur,
                                            @QueryParam("sectionCode") String sectionCode,
                                            @QueryParam("natureDepense") String natureDepense,
                                            @QueryParam("programme") String programme,
                                            @QueryParam("action") String action){
        List<LigneDepense> ligneDepenses = ligneDepenseService.findByCritere(exercice, sourceFinancement,natureEconomiqueCode, activiteCode, bailleur, sectionCode, natureDepense, programme, action);
        LOG.info("NB Ligne : " + ligneDepenses.size());
        return ligneDepenses;
    }

    @GET
    @Path("/criteres/paginated")
    public List<LigneDepense> findByCriterePaginated(@QueryParam("exercice") String exercice,
                                                    @QueryParam("sourceFinancement") String sourceFinancement,
                                                    @QueryParam("natureEconomiqueCode") String natureEconomiqueCode,
                                                    @QueryParam("activiteCode") String activiteCode,
                                                    @QueryParam("bailleur") String bailleur,
                                                    @QueryParam("sectionCode") String sectionCode,
                                                    @QueryParam("natureDepense") String natureDepense,
                                                    @QueryParam("programme") String programme,
                                                    @QueryParam("action") String action,
                                                    @QueryParam("indexPremierElement") int indexPremierElement,
                                                    @QueryParam("nombreElements") int nombreElements){
        List<LigneDepense> ligneDepenses = ligneDepenseService.findByCriterePaginated(exercice, sourceFinancement,natureEconomiqueCode, activiteCode, bailleur, sectionCode, natureDepense, programme, action, indexPremierElement, nombreElements);
        LOG.info("NB Ligne : " + ligneDepenses.size());
        return ligneDepenses;
    }

    @GET
    @Path("/criteres/count")
    public long countByCritere(@QueryParam("exercice") String exercice,
                               @QueryParam("sourceFinancement") String sourceFinancement,
                               @QueryParam("natureEconomiqueCode") String natureEconomiqueCode,
                               @QueryParam("activiteCode") String activiteCode,
                               @QueryParam("bailleur") String bailleur,
                               @QueryParam("sectionCode") String sectionCode,
                               @QueryParam("natureDepense") String natureDepense,
                               @QueryParam("programme") String programme,
                               @QueryParam("action") String action){
        return ligneDepenseService.countByCritere(exercice, sourceFinancement,natureEconomiqueCode, activiteCode, bailleur, sectionCode, natureDepense, programme, action);
    }

    @POST
    @Path("/criteres/operations")
    public List<LigneDepense> findByOperation(List<LigneOperation> ligneOperationList){
        return ligneDepenseService.findByOperation(ligneOperationList);
    }
}
