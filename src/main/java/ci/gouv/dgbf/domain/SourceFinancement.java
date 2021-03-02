package ci.gouv.dgbf.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "V_SOURCE_FINANCEMENT")
@Immutable
public class SourceFinancement {
    @Id
    @Column(name = "SFIN_ID")
    public String sourceFinancementId;

    @Column(name = "SFIN_CODE")
    public String sourceFinancementCode;

    @Column(name = "SFIN_LIBCT")
    public String sourceFinancementLibelle;
}
