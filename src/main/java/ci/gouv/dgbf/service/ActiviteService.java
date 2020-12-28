package ci.gouv.dgbf.service;

import ci.gouv.dgbf.client.ActiviteClient;
import ci.gouv.dgbf.client.NatureEconomiqueClient;
import ci.gouv.dgbf.dto.Activite;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ActiviteService implements ActiviteClient {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

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
}
