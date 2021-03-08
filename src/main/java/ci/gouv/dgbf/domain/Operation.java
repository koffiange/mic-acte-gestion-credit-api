package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Operation extends BaseEntity{
    public String ligneDepenseUuid;
    public String activiteCode;
    public String activiteLibelle;
    public String natureEconomiqueCode;
    public String natureEconomiqueLibelle;
    public String exercice;
    public String sourceFinancementCode;
    public String sourceFinancementLibelle;
    public String sectionCode;
    public String sectionLibelle;
    public String bailleurId;
    public String bailleurLibelle;
    public BigDecimal budgetActuelAE;
    public BigDecimal budgetActuelCP;
    public BigDecimal montantOperationAE;
    public BigDecimal montantOperationCP;
    public String financementId;
    @Transient
    public BigDecimal montantDisponibleAe;
    @Transient
    public BigDecimal montantDisponibleCp;
    @Enumerated(value = EnumType.STRING)
    public TypeOperation typeOperation;
    @Enumerated(value = EnumType.STRING)
    public EffetOperation effetOperation;
    @Enumerated(value = EnumType.STRING)
    public DisponibiliteCreditOperation disponibiliteCredit;
    @Enumerated(value = EnumType.STRING)
    public OrigineImputation origineImputation;

    @ManyToOne
    public Acte acte;

    public Operation() {
    }



}
