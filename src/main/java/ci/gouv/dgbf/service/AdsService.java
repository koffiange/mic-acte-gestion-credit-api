package ci.gouv.dgbf.service;

import ci.gouv.dgbf.client.ActiviteClient;
import ci.gouv.dgbf.client.NatureEconomiqueClient;
import ci.gouv.dgbf.domain.ActiviteDeService;
import ci.gouv.dgbf.dto.Activite;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class AdsService {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    EntityManager em;

    private final String baseQuery="SELECT ads FROM V_ACTIVITE_DE_SERVICE ads ";

    @Inject
    @ConfigProperty(name = "application.ads.api.uri", defaultValue = "http://mic-activite-de-service-api/api/v1/")
    String baseUri;
    URI apiUri;

    public ActiviteDeService findByCode(String code) {
        String stringQuery = baseQuery.concat("WHERE ads.adscode = :code");
        TypedQuery<ActiviteDeService> query = em.createQuery(stringQuery, ActiviteDeService.class);
        return query.getSingleResult();
    }

    public List<ActiviteDeService> listAll(){
        TypedQuery<ActiviteDeService> query = em.createQuery(baseQuery, ActiviteDeService.class);
        return query.getResultList();
    }

    public List<ActiviteDeService> findBySectionCode(String sectionCode){
        String stringQuery = baseQuery.concat("WHERE ads.sectionCode = :sectionCode");
        TypedQuery<ActiviteDeService> query = em.createQuery(stringQuery, ActiviteDeService.class);
        query.setParameter("sectionCode", sectionCode);
        return query.getResultList();
    }


}
