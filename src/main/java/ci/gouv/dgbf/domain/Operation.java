package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.DisponibiliteCreditOperation;
import ci.gouv.dgbf.enumeration.EffetOperation;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Operation extends BaseEntity{
    public String ligneDepenseUuid;
    public String activiteCode;
    public String activiteLibelle;
    public String natureEconomiqueCode;
    public String natureEconomique;
    public String exercice;
    public BigDecimal budgetActuelAE;
    public BigDecimal budgetActuelCP;
    public BigDecimal montantOperationAE;
    public BigDecimal montantOperationCP;
    public EffetOperation effetOperation;
    public DisponibiliteCreditOperation disponibiliteCredit;

    @ManyToOne
    public Acte acte;

    public Operation() {
    }



}