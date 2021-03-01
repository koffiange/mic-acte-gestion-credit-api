package ci.gouv.dgbf.dto;

import ci.gouv.dgbf.domain.Bailleur;
import ci.gouv.dgbf.domain.SourceFinancement;

import java.math.BigDecimal;

public class ImputationDto {
    public Activite activite;
    public NatureEcnomique natureEcnomique;
    public SourceFinancement sourceFinancement;
    public Bailleur bailleur;
    public BigDecimal montantAe;
    public BigDecimal montantCp;

    public ImputationDto() {
    }

    @Override
    public String toString() {
        return "ImputationDto{" +
                "activite=" + activite +
                ", natureEcnomique=" + natureEcnomique +
                ", sourceFinancement=" + sourceFinancement +
                ", bailleur=" + bailleur +
                ", montantAe=" + montantAe +
                ", montantCp=" + montantCp +
                '}';
    }
}
