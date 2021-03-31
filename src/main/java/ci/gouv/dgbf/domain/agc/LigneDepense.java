package ci.gouv.dgbf.domain.agc;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "V_LIGNE_DEPENSE_IMPUTABLE")
@Immutable
public class LigneDepense{
    @Id
    @Column(updatable = false, nullable = false)
    public String ligneDepenseId;
    public String financementId;
    public String plafonId;
    public String exercice;
    public String natureEconomiqueId;
    public String natureEconomiqueCode;
    public String natureEconomiqueLibelle;
    public String usbId;
    public String usbCode;
    public String usbLibelle;
    public String sectionId;
    public String sectionCode;
    public String sectionLibelle;
    public String activiteId;
    public String activiteCode;
    public String activiteLibelle;
    public String actionId;
    public String actionCode;
    public String actionLibelle;
    public String uaId;
    public String bailleurId;
    public String bailleurLibelle;
    public String sourceFinancementId;
    public String sourceFinancementCode;
    public String sourceFinancementLibelle;
    public BigDecimal montantAe;
    public BigDecimal montantCp;
    public BigDecimal montantDisponibleAE;
    public BigDecimal montantDisponibleCP;
    public String natureDepense;
    public String ligneStatut;


    public LigneDepense() {
    }

    public LigneDepense(String ligneDepenseId, String exercice, String activiteId,
                        String natureEconomiqueId, String natureEconomiqueCode,
                        String natureEconomiqueLibelle, String activiteCode,
                        String activiteLibelle, String sourceFinancementId, String usbId, String sectionId,
                        String sectionLibelle, String sectionCode, String uaId,
                        String secbId, BigDecimal montantAe, BigDecimal montantCp,
                        BigDecimal montantDisponibleAE, BigDecimal montantDisponibleCP,String natureDepense,
                        String actionCode, String actionLibelle, String usbCode, String usbLibelle, String ligneStatut) {
        this.ligneDepenseId = ligneDepenseId;
        this.exercice = exercice;
        this.activiteId = activiteId;
        this.natureEconomiqueId = natureEconomiqueId;
        this.natureEconomiqueCode = natureEconomiqueCode;
        this.natureEconomiqueLibelle = natureEconomiqueLibelle;
        this.activiteCode = activiteCode;
        this.activiteLibelle = activiteLibelle;
        this.usbId = usbId;
        this.sectionId = sectionId;
        this.sectionLibelle = sectionLibelle;
        this.sectionCode = sectionCode;
        this.uaId = uaId;
        this.sourceFinancementId = sourceFinancementId;
        this.sectionId = secbId;
        this.montantAe = montantAe;
        this.montantCp = montantCp;
        this.montantDisponibleAE = montantDisponibleAE;
        this.montantDisponibleCP = montantDisponibleCP;
        this.natureDepense = natureDepense;
        this.actionCode = actionCode;
        this.actionLibelle = actionLibelle;
        this.usbCode = usbCode;
        this.usbLibelle = usbLibelle;
        this.ligneStatut = ligneStatut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneDepense that = (LigneDepense) o;
        return Objects.equals(ligneDepenseId, that.ligneDepenseId) && Objects.equals(exercice, that.exercice) && Objects.equals(natureEconomiqueId, that.natureEconomiqueId) && Objects.equals(natureEconomiqueCode, that.natureEconomiqueCode) && Objects.equals(natureEconomiqueLibelle, that.natureEconomiqueLibelle) && Objects.equals(activiteId, that.activiteId) && Objects.equals(usbId, that.usbId) && Objects.equals(usbCode, that.usbCode) && Objects.equals(usbLibelle, that.usbLibelle) && Objects.equals(sectionId, that.sectionId) && Objects.equals(sectionCode, that.sectionCode) && Objects.equals(sectionLibelle, that.sectionLibelle) && Objects.equals(activiteCode, that.activiteCode) && Objects.equals(activiteLibelle, that.activiteLibelle) && Objects.equals(actionCode, that.actionCode) && Objects.equals(actionLibelle, that.actionLibelle) && Objects.equals(uaId, that.uaId) && Objects.equals(bailleurId, that.bailleurId) && Objects.equals(bailleurLibelle, that.bailleurLibelle) && Objects.equals(sourceFinancementId, that.sourceFinancementId) && Objects.equals(sourceFinancementCode, that.sourceFinancementCode) && Objects.equals(sourceFinancementLibelle, that.sourceFinancementLibelle) && Objects.equals(montantAe, that.montantAe) && Objects.equals(montantCp, that.montantCp) && Objects.equals(montantDisponibleAE, that.montantDisponibleAE) && Objects.equals(montantDisponibleCP, that.montantDisponibleCP) && Objects.equals(natureDepense, that.natureDepense) && Objects.equals(ligneStatut, that.ligneStatut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ligneDepenseId, exercice, natureEconomiqueId, natureEconomiqueCode, natureEconomiqueLibelle, activiteId, usbId, usbCode, usbLibelle, sectionId, sectionCode, sectionLibelle, activiteCode, activiteLibelle, actionCode, actionLibelle, uaId, bailleurId, bailleurLibelle, sourceFinancementId, sourceFinancementCode, sourceFinancementLibelle, montantAe, montantCp, montantDisponibleAE, montantDisponibleCP, natureDepense, ligneStatut);
    }

    @Override
    public String toString() {
        return "LigneDepense{" +
                "ligneDepenseId='" + ligneDepenseId + '\'' +
                ", exercice='" + exercice + '\'' +
                ", natureEconomiqueId='" + natureEconomiqueId + '\'' +
                ", natureEconomiqueCode='" + natureEconomiqueCode + '\'' +
                ", natureEconomiqueLibelle='" + natureEconomiqueLibelle + '\'' +
                ", activiteId='" + activiteId + '\'' +
                ", usbId='" + usbId + '\'' +
                ", usbCode='" + usbCode + '\'' +
                ", usbLibelle='" + usbLibelle + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                ", sectionLibelle='" + sectionLibelle + '\'' +
                ", activiteCode='" + activiteCode + '\'' +
                ", activiteLibelle='" + activiteLibelle + '\'' +
                ", actionCode='" + actionCode + '\'' +
                ", actionLibelle='" + actionLibelle + '\'' +
                ", uaId='" + uaId + '\'' +
                ", bailleurId='" + bailleurId + '\'' +
                ", bailleurLibelle='" + bailleurLibelle + '\'' +
                ", sourceFinancementId='" + sourceFinancementId + '\'' +
                ", sourceFinancementCode='" + sourceFinancementCode + '\'' +
                ", sourceFinancementLibelle='" + sourceFinancementLibelle + '\'' +
                ", montantAe=" + montantAe +
                ", montantCp=" + montantCp +
                ", montantDisponibleAE=" + montantDisponibleAE +
                ", montantDisponibleCP=" + montantDisponibleCP +
                ", natureDepense='" + natureDepense + '\'' +
                ", ligneStatut='" + ligneStatut + '\'' +
                '}';
    }
}
