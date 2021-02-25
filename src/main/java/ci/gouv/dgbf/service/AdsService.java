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
public class AdsService implements ActiviteClient {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    EntityManager em;

    private final String baseQuery="SELECT ads FROM V_ACTIVITE_DE_SERVICE ads ";

    @Inject
    @ConfigProperty(name = "application.ads.api.uri", defaultValue = "http://mic-activite-de-service-api/api/v1/")
    String baseUri;
    URI apiUri;
    ActiviteClient client;

    @PostConstruct
    public void init() {
        try {
            apiUri = new URI(baseUri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        client = RestClientBuilder.newBuilder()
                .baseUri(apiUri)
                .build(ActiviteClient.class);
    }


    @Override
    public List<Activite> findAll() {
        return client.findAll();
    }

    @Override
    public Activite findByCode(String code) {
        return client.findByCode(code);
    }

    public List<ActiviteDeService> findBySectionCode(String sectionCode){
        String stringQuery = baseQuery.concat("WHERE ads.sectionCode = :sectionCode");
        TypedQuery<ActiviteDeService> query = em.createQuery(stringQuery, ActiviteDeService.class);
        query.setParameter("sectionCode", sectionCode);
        return query.getResultList();
    }


}
