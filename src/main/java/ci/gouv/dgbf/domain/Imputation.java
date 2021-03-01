package ci.gouv.dgbf.domain;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Imputation extends BaseEntity {
    public String activiteId;
    public String natureEcnomiqueId;
    public String sourceFinancementId;
    public String bailleurId;
    public BigDecimal montantAe;
    public BigDecimal montantCp;

    public Imputation() {
    }

    @Override
    public String toString() {
        return "Imputation{" +
                "activiteId='" + activiteId + '\'' +
                ", natureEcnomiqueId='" + natureEcnomiqueId + '\'' +
                ", sourceFinancementId='" + sourceFinancementId + '\'' +
                ", bailleurId='" + bailleurId + '\'' +
                ", montantAe=" + montantAe +
                ", montantCp=" + montantCp +
                '}';
    }
}
