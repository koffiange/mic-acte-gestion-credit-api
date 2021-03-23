package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class LigneOperation extends BaseEntity{
    public String ligneDepenseUuid;
    public String usbCode;
    public String usbLibelle;
    public String sectionCode;
    public String sectionLibelle;
    public String activiteCode;
    public String activiteLibelle;
    public String natureEconomiqueCode;
    public String natureEconomiqueLibelle;
    public String sourceFinancementCode;
    public String sourceFinancementLibelle;
    public String bailleurCode;
    public String bailleurLibelle;
    public String exercice;
    public String financementId;
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

    @ManyToOne
    @JoinColumn(name = "OPERATION_ID")
    public Operation operation;

    public LigneOperation() {
    }



}
