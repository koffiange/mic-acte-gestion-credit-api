package ci.gouv.dgbf.dto;

import ci.gouv.dgbf.domain.ActiviteDeService;
import ci.gouv.dgbf.domain.Bailleur;
import ci.gouv.dgbf.domain.SourceFinancement;

import java.math.BigDecimal;

public class ImputationDto {
    public String uuid;
    public String exercice;
    public Section section;
    public ActiviteDeService activiteDeService;
    public NatureEconomique natureEconomique;
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
                ", natureEconomique=" + natureEconomique +
                ", sourceFinancement=" + sourceFinancement +
                ", bailleur=" + bailleur +
                ", montantAe=" + montantAe +
                ", montantCp=" + montantCp +
                '}';
    }
}
