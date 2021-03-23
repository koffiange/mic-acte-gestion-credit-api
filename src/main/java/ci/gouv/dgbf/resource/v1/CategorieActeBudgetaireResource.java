package ci.gouv.dgbf.resource.v1;

import ci.gouv.dgbf.domain.CategorieActeBudgetaire;
import ci.gouv.dgbf.enumeration.CategorieActeUsage;
import ci.gouv.dgbf.enumeration.NatureActe;
import ci.gouv.dgbf.enumeration.TypeActe;
import ci.gouv.dgbf.service.CategorieActeBudgetaireService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/categories-acte")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Tag(name="Categorie Acte", description="Opération relatives aux Categorie d'acte")
public class CategorieActeBudgetaireResource {

    @Inject
    CategorieActeBudgetaireService cabService;

    @GET
    public List<CategorieActeBudgetaire> listAll(){
        return cabService.listAll();
    }

    @GET
    @Path("/{uuid}")
    public CategorieActeBudgetaire findById(String uuid){
        return cabService.findById(uuid);
    }

    @GET
    @Path("/usage/{usage}")
    public List<CategorieActeBudgetaire> findByUsage(@PathParam("usage") String usage){
        CategorieActeUsage categorieActeUsage = CategorieActeUsage.valueOf(usage);
        return cabService.findByUsage(categorieActeUsage);
    }

    @GET
    @Path("/nature-acte/{natureacte}")
    public List<CategorieActeBudgetaire> findByNatureActe(@PathParam("natureacte") String natureacte){
        NatureActe natureActe = NatureActe.valueOf(natureacte);
        return cabService.findByNatureActe(natureActe);
    }

    @GET
    @Path("/nature-acte/{typeacte}")
    public List<CategorieActeBudgetaire> findByTypeActe(@PathParam("typeacte") String typeacte){
        TypeActe typeActe = TypeActe.valueOf(typeacte);
        return cabService.findByTypeActe(typeActe);
    }
}
