package ci.gouv.dgbf.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "V_LIGNE_DEPENSE")
@Immutable
public class LigneDepense{
    @Id
    @Column(updatable = false, nullable = false)
    public String ligneDepenseId;
    public String exercice;
    public String activiteId;
    public String natureEconomiqueId;
    public String natureEconomiqueCode;
    public String natureEconomiqueLibelle;
    public String activiteCode;
    public String activiteLibelle;
    public String usbId;
    public String sectionId;
    public String sectionLibelle;
    public String sectionCode;
    public String uaId;
    public String financementId;
    public BigDecimal montantAe;
    public BigDecimal montantCp;

    public LigneDepense() {
    }

    public LigneDepense(String ligneDepenseId, String exercice, String activiteId,
                        String natureEconomiqueId, String natureEconomiqueCode,
                        String natureEconomiqueLibelle, String activiteCode,
                        String activiteLibelle, String usbId, String sectionId,
                        String sectionLibelle, String sectionCode, String uaId,
                        String secbId, String financementId, BigDecimal montantAe,
                        BigDecimal montantCp) {
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
        this.sectionId = secbId;
        this.financementId = financementId;
        this.montantAe = montantAe;
        this.montantCp = montantCp;
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
                Objects.equals(sectionId, that.sectionId) &&
                Objects.equals(financementId, that.financementId) &&
                Objects.equals(montantAe, that.montantAe) &&
                Objects.equals(montantCp, that.montantCp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ligneDepenseId, exercice, activiteId, natureEconomiqueId, natureEconomiqueCode, natureEconomiqueLibelle, activiteCode, activiteLibelle, usbId, sectionId, sectionLibelle, sectionCode, uaId, sectionId, financementId, montantAe, montantCp);
    }
}
