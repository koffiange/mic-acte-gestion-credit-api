package ci.gouv.dgbf.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "V_LIGNE_DEPENSE_IMPUTABLE")
@Immutable
public class LigneDepense{
    @Id
    @Column(updatable = false, nullable = false)
    public String ligneDepenseId;
    public String exercice;
    public String natureEconomiqueId;
    public String natureEconomiqueCode;
    public String natureEconomiqueLibelle;
    public String activiteId;
    public String activiteCode;
    public String activiteLibelle;
    public String usbId;
    public String sectionId;
    public String sectionCode;
    public String sectionLibelle;
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
    public String actionCode;
    public String actionLibelle;
    public String usbCode;
    public String usbLibelle;
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
        return Objects.equals(ligneDepenseId, that.ligneDepenseId) &&
                Objects.equals(exercice, that.exercice) &&
                Objects.equals(activiteId, that.activiteId) &&
                Objects.equals(natureEconomiqueId, that.natureEconomiqueId) &&
                Objects.equals(natureEconomiqueCode, that.natureEconomiqueCode) &&
                Objects.equals(natureEconomiqueLibelle, that.natureEconomiqueLibelle) &&
                Objects.equals(activiteCode, that.activiteCode) &&
                Objects.equals(activiteLibelle, that.activiteLibelle) &&
                Objects.equals(usbId, that.usbId) &&
                Objects.equals(sectionId, that.sectionId) &&
                Objects.equals(sectionLibelle, that.sectionLibelle) &&
                Objects.equals(sectionCode, that.sectionCode) &&
                Objects.equals(uaId, that.uaId) &&
                Objects.equals(montantAe, that.montantAe) &&
                Objects.equals(montantCp, that.montantCp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ligneDepenseId, exercice, activiteId, natureEconomiqueId, natureEconomiqueCode, natureEconomiqueLibelle, activiteCode, activiteLibelle, usbId, sectionId, sectionLibelle, sectionCode, uaId, sectionId, montantAe, montantCp);
    }
}
