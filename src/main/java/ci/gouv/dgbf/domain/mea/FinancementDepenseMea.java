package ci.gouv.dgbf.domain.mea;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "FINANCEMENT_DEPENSES")
public class FinancementDepenseMea {
    @Id
    @Column(name = "FIND_ID")
    public String uuid;

    @Column(name = "PLFD_ID")
    public String plafondId;

    @Column(name = "LDEP_ID")
    public String ligneDepenseId;

    @Column(name = "BAI_ID")
    public String bailleurId;

    @Column(name = "SFIN_ID")
    public String sourceFinancementId;

    @Column(name = "FIND_MONTANT_AE")
    public String montantAE;

    @Column(name = "FIND_MONTANT_CP")
    public String montantCP;

    @Column(name = "CAT_REG_ID")
    public String categorieRegulationId;

    @Column(name = "ACTE_ID")
    public String acteId;

    @Column(name = "ETAT")
    public String etat;

    @Column(name = "DATE_ETAT")
    public LocalDate categorieId;

    @Column(name = "COMMENTAIRE_ETAT")
    public String commentaireEtat;

    @Column(name = "FIND_BVOTE_AE")
    public String budgetVoteAE;

    @Column(name = "FIND_BVOTE_CP")
    public String budgetVoteCP;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancementDepenseMea that = (FinancementDepenseMea) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(plafondId, that.plafondId) && Objects.equals(ligneDepenseId, that.ligneDepenseId) && Objects.equals(bailleurId, that.bailleurId) && Objects.equals(sourceFinancementId, that.sourceFinancementId) && Objects.equals(montantAE, that.montantAE) && Objects.equals(montantCP, that.montantCP) && Objects.equals(categorieRegulationId, that.categorieRegulationId) && Objects.equals(acteId, that.acteId) && Objects.equals(etat, that.etat) && Objects.equals(categorieId, that.categorieId) && Objects.equals(commentaireEtat, that.commentaireEtat) && Objects.equals(budgetVoteAE, that.budgetVoteAE) && Objects.equals(budgetVoteCP, that.budgetVoteCP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, plafondId, ligneDepenseId, bailleurId, sourceFinancementId, montantAE, montantCP, categorieRegulationId, acteId, etat, categorieId, commentaireEtat, budgetVoteAE, budgetVoteCP);
    }

    @Override
    public String toString() {
        return "FinancementDepenseMea{" +
                "uuid='" + uuid + '\'' +
                ", plafondId='" + plafondId + '\'' +
                ", ligneDepenseId='" + ligneDepenseId + '\'' +
                ", bailleurId='" + bailleurId + '\'' +
                ", sourceFinancementId='" + sourceFinancementId + '\'' +
                ", montantAE='" + montantAE + '\'' +
                ", montantCP='" + montantCP + '\'' +
                ", categorieRegulationId='" + categorieRegulationId + '\'' +
                ", acteId='" + acteId + '\'' +
                ", etat='" + etat + '\'' +
                ", categorieId=" + categorieId +
                ", commentaireEtat='" + commentaireEtat + '\'' +
                ", budgetVoteAE='" + budgetVoteAE + '\'' +
                ", budgetVoteCP='" + budgetVoteCP + '\'' +
                '}';
    }
}
