package ci.gouv.dgbf.dto;

import ci.gouv.dgbf.domain.ActiviteDeService;
import ci.gouv.dgbf.domain.Bailleur;
import ci.gouv.dgbf.domain.SourceFinancement;

import java.math.BigDecimal;
import java.util.UUID;

public class ImputationDto {
    public String uuid;
    public String exercice;
    public Section section;
    public ActiviteDeService activiteDeService;
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
                "activite=" + activiteDeService +
                ", natureEcnomique=" + natureEcnomique +
                ", sourceFinancement=" + sourceFinancement +
                ", bailleur=" + bailleur +
                ", montantAe=" + montantAe +
                ", montantCp=" + montantCp +
                '}';
    }
}
