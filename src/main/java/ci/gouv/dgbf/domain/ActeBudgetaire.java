package ci.gouv.dgbf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTE_BUDGETAIRE")
public class ActeBudgetaire{
    @Id
    @Column(name = "ACTE_ID", updatable = false, nullable = false)
    public String ligneDepenseId;
    @Column(name = "ACTE_DATE_ACTE")
    public String date;
    @Column(name = "ACTE_DESIGNATION")
    public String libelle;
    @Column(name = "CADEP_ID")
    public String natureActe;
    @Column(name = "EXO_NUM")
    public String exercice;
}
