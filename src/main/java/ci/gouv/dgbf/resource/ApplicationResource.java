package ci.gouv.dgbf.resource;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title="Acte de Gestion des Crédits API",
                version = "1.0.0",
                contact = @Contact(
                        name = "DGBF/ DTI/ Koffi Ange Stéphane (Développeur)",
                        email = "koffiange62@gmail.com"))
)
public class ApplicationResource extends Application {
}
