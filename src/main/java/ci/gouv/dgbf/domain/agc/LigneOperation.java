package ci.gouv.dgbf.domain.agc;

import ci.gouv.dgbf.enumeration.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class LigneOperation extends BaseEntity{
    public String ligneDepenseUuid;
    public String financementId;
    public String plafonId;
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
    public String natureEconomiqueId;
    public String natureEconomiqueCode;
    public String natureEconomiqueLibelle;
    public String sourceFinancementCode;
    public String sourceFinancementLibelle;
    public String bailleurId;
    public String bailleurCode;
    public String bailleurLibelle;
    public String exercice;
    public BigDecimal budgetActuelAE;
    public BigDecimal budgetActuelCP;
    public BigDecimal montantDisponibleAE;
    public BigDecimal montantDisponibleCP;
    public BigDecimal montantOperationAE;
    public BigDecimal montantOperationCP;
    public BigDecimal disponibleRestantAE;
    public BigDecimal disponibleRestantCP;
    @Enumerated(value = EnumType.STRING)
    public TypeOperation typeOperation;
    @Enumerated(value = EnumType.STRING)
    public EffetOperation effetOperation;
    @Enumerated(value = EnumType.STRING)
    public DisponibiliteCreditOperation disponibiliteCredit;
    @Enumerated(value = EnumType.STRING)
    public OrigineImputation origineImputation;
    public String natureDepense;

    @ManyToOne
    @JoinColumn(name = "OPERATION_ID")
    public Operation operation;

    public LigneOperation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneOperation that = (LigneOperation) o;
        return Objects.equals(ligneDepenseUuid, that.ligneDepenseUuid) && Objects.equals(usbCode, that.usbCode) && Objects.equals(usbLibelle, that.usbLibelle) && Objects.equals(sectionCode, that.sectionCode) && Objects.equals(sectionLibelle, that.sectionLibelle) && Objects.equals(activiteCode, that.activiteCode) && Objects.equals(activiteLibelle, that.activiteLibelle) && Objects.equals(natureEconomiqueCode, that.natureEconomiqueCode) && Objects.equals(natureEconomiqueLibelle, that.natureEconomiqueLibelle) && Objects.equals(sourceFinancementCode, that.sourceFinancementCode) && Objects.equals(sourceFinancementLibelle, that.sourceFinancementLibelle) && Objects.equals(bailleurCode, that.bailleurCode) && Objects.equals(bailleurLibelle, that.bailleurLibelle) && Objects.equals(exercice, that.exercice) && Objects.equals(financementId, that.financementId) && Objects.equals(budgetActuelAE, that.budgetActuelAE) && Objects.equals(budgetActuelCP, that.budgetActuelCP) && Objects.equals(montantDisponibleAE, that.montantDisponibleAE) && Objects.equals(montantDisponibleCP, that.montantDisponibleCP) && Objects.equals(montantOperationAE, that.montantOperationAE) && Objects.equals(montantOperationCP, that.montantOperationCP) && Objects.equals(disponibleRestantAE, that.disponibleRestantAE) && Objects.equals(disponibleRestantCP, that.disponibleRestantCP) && typeOperation == that.typeOperation && effetOperation == that.effetOperation && disponibiliteCredit == that.disponibiliteCredit && origineImputation == that.origineImputation && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ligneDepenseUuid, usbCode, usbLibelle, sectionCode, sectionLibelle, activiteCode, activiteLibelle, natureEconomiqueCode, natureEconomiqueLibelle, sourceFinancementCode, sourceFinancementLibelle, bailleurCode, bailleurLibelle, exercice, financementId, budgetActuelAE, budgetActuelCP, montantDisponibleAE, montantDisponibleCP, montantOperationAE, montantOperationCP, disponibleRestantAE, disponibleRestantCP, typeOperation, effetOperation, disponibiliteCredit, origineImputation, operation);
    }

    @Override
    public String toString() {
        return "LigneOperation{" +
                "ligneDepenseUuid='" + ligneDepenseUuid + '\'' +
                ", usbCode='" + usbCode + '\'' +
                ", usbLibelle='" + usbLibelle + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                ", sectionLibelle='" + sectionLibelle + '\'' +
                ", activiteCode='" + activiteCode + '\'' +
                ", activiteLibelle='" + activiteLibelle + '\'' +
                ", natureEconomiqueCode='" + natureEconomiqueCode + '\'' +
                ", natureEconomiqueLibelle='" + natureEconomiqueLibelle + '\'' +
                ", sourceFinancementCode='" + sourceFinancementCode + '\'' +
                ", sourceFinancementLibelle='" + sourceFinancementLibelle + '\'' +
                ", bailleurCode='" + bailleurCode + '\'' +
                ", bailleurLibelle='" + bailleurLibelle + '\'' +
                ", exercice='" + exercice + '\'' +
                ", financementId='" + financementId + '\'' +
                ", budgetActuelAE=" + budgetActuelAE +
                ", budgetActuelCP=" + budgetActuelCP +
                ", montantDisponibleAE=" + montantDisponibleAE +
                ", montantDisponibleCP=" + montantDisponibleCP +
                ", montantOperationAE=" + montantOperationAE +
                ", montantOperationCP=" + montantOperationCP +
                ", disponibleRestantAE=" + disponibleRestantAE +
                ", disponibleRestantCP=" + disponibleRestantCP +
                ", typeOperation=" + typeOperation +
                ", effetOperation=" + effetOperation +
                ", disponibiliteCredit=" + disponibiliteCredit +
                ", origineImputation=" + origineImputation +
                ", operation=" + operation +
                '}';
    }
}
