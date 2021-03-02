package ci.gouv.dgbf.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.invoke.SerializedLambda;

@Entity(name = "V_SOURCE_FINANCEMENT")
@Immutable
public class SourceFinancement {
    @Id
    public String sourceFinancementId;
    public String sourceFinancementCode;
    public String sourceFinancementLibelle;
}
