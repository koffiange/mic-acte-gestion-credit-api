package ci.gouv.dgbf.service;

import ci.gouv.dgbf.client.NatureEconomiqueClient;
import ci.gouv.dgbf.dto.NatureEcnomique;
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
public class NatureEconomiqueService implements NatureEconomiqueClient {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    @ConfigProperty(name = "application.nat.eco.api.uri", defaultValue = "http://mic-classification-economique-api/api/v1/")
    String baseUri;
    URI apiUri;
    NatureEconomiqueClient client;

    @PostConstruct
    public void init() {
        try {
            apiUri = new URI(baseUri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        client = RestClientBuilder.newBuilder()
                .baseUri(apiUri)
                .build(NatureEconomiqueClient.class);
    }

    @Override
    public List<NatureEcnomique> findAll() {
        return client.findAll();
    }

    @Override
    public NatureEcnomique findByCode(String code) {
        return client.findByCode(code);
    }

    @Override
    public NatureEcnomique findByUuid(String uuid) {
        return client.findByUuid(uuid);
    }

}
