package ci.gouv.dgbf.domain.mea;

import ci.gouv.dgbf.domain.agc.Acte;
import ci.gouv.dgbf.domain.agc.LigneOperation;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_ACTE")
@IdClass(OperationMeaId.class)
public class OperationMea {
    @Id
    @Column(name = "ACTE_ID")
    public String acteId;
    @Id
    @Column(name = "LDEP_ID")
    public String ligneDepenseId;
    @Id
    @Column(name = "FIND_ID", nullable = true)
    public String financementId;

    @Column(name = "TYPE_ACTE")
    public String typeActe;
    @Column(name = "TYPE_OPERATION")
    public String typeOperation;
    @Lob
    @Column(name = "OBJET_ACTE")
    public String objetActe;
    @Column(name = "MONTANT_AE")
    public BigDecimal montantAE;
    @Column(name = "MONTANT_CP")
    public BigDecimal montantCP;
    @Column(name = "ETAT")
    public String etat;
    @Column(name = "DATE_ETAT")
    public LocalDateTime dateEtat;
    @Lob
    @Column(name = "COMMENTAIRE_ETAT")
    public String commentaireEtat;
    @Column(name = "NATURE_ACTE")
    public String natureActe;
    @Column(name = "SENS_OPERATION")
    public String sensOperation;
    @Column(name = "REF_ACTE")
    public String referenceActe;
    @Column(name = "DATE_ACTE")
    public LocalDate dateActe;

    public OperationMea() {
    }

    public OperationMea(LigneOperation ligneOperation, Acte acte) {
        this.acteId = acte.uuid;
        this.ligneDepenseId = ligneOperation.ligneDepenseUuid;
        this.financementId = (ligneOperation.financementId != null) ? ligneOperation.financementId : "NON_FINANCE";
        this.typeActe = acte.categorieActe.acteType;
        this.objetActe = null;
        this.montantAE = ligneOperation.montantOperationAE;
        this.montantCP = ligneOperation.montantOperationCP;
        this.etat = "NOUV";
        this.dateEtat = LocalDateTime.now();
        this.dateActe = acte.dateSignature;
        this.commentaireEtat = null;
        this.referenceActe = acte.reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationMea operationMea = (OperationMea) o;
        return Objects.equals(acteId, operationMea.acteId) && Objects.equals(ligneDepenseId, operationMea.ligneDepenseId) && Objects.equals(financementId, operationMea.financementId) && Objects.equals(typeActe, operationMea.typeActe) && Objects.equals(objetActe, operationMea.objetActe) && Objects.equals(montantAE, operationMea.montantAE) && Objects.equals(montantCP, operationMea.montantCP) && Objects.equals(etat, operationMea.etat) && Objects.equals(dateEtat, operationMea.dateEtat) && Objects.equals(commentaireEtat, operationMea.commentaireEtat) && Objects.equals(referenceActe, operationMea.referenceActe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acteId, ligneDepenseId, financementId, typeActe, objetActe, montantAE, montantCP, etat, dateEtat, commentaireEtat, referenceActe);
    }

    @Override
    public String toString() {
        return "OperationMea{" +
                "acteId='" + acteId + '\'' +
                ", ligneDepenseId='" + ligneDepenseId + '\'' +
                ", financementId='" + financementId + '\'' +
                ", typeActe='" + typeActe + '\'' +
                ", objetActe='" + objetActe + '\'' +
                ", montantAE='" + montantAE + '\'' +
                ", montantCP='" + montantCP + '\'' +
                ", etat='" + etat + '\'' +
                ", dateEtat='" + dateEtat + '\'' +
                ", commentaireEtat='" + commentaireEtat + '\'' +
                ", referenceActe='" + referenceActe + '\'' +
                '}';
    }
}
