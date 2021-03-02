package ci.gouv.dgbf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "FINANCEMENT_BIDF")
public class FinancementBidf {
    @Id
    @Column(name = "ID")
    public String uuid;
    @Column(name = "LDEP_ID")
    public String ligneDepenseId;
    @Column(name = "BAI_ID")
    public String bailleurId;
    @Column(name = "FIND_MONTANT_AE")
    public String montantAE;
    @Column(name = "FIND_MONTANT_CP")
    public String montantCP;
    @Column(name = "ACTE_ID")
    public String acteId;
    @Column(name = "FIND_BVOTE_AE")
    public String findBudgetVoteAE;
    @Column(name = "FIND_BVOTE_CP")
    public String findBudgetVoteCP;
    @Column(name = "ETAT")
    public String financementEtat;
}
