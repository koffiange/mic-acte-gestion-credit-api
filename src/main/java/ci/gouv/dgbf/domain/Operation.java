package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.DisponibiliteCreditOperation;
import ci.gouv.dgbf.enumeration.EffetOperation;
import ci.gouv.dgbf.enumeration.NatureTransaction;
import ci.gouv.dgbf.enumeration.TypeOperation;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Operation extends BaseEntity{
    public String ligneDepenseUuid;
    public String activiteCode;
    public String activiteLibelle;
    public String natureEconomiqueCode;
    public String natureEconomiqueLibelle;
    public String exercice;
    public String sourceFinancement;
    public BigDecimal budgetActuelAE;
    public BigDecimal budgetActuelCP;
    public BigDecimal montantOperationAE;
    public BigDecimal montantOperationCP;
    @Enumerated(value = EnumType.STRING)
    public TypeOperation typeOperation;
    @Enumerated(value = EnumType.STRING)
    public EffetOperation effetOperation;
    @Enumerated(value = EnumType.STRING)
    public DisponibiliteCreditOperation disponibiliteCredit;

    @ManyToOne
    public Acte acte;

    public Operation() {
    }



}
