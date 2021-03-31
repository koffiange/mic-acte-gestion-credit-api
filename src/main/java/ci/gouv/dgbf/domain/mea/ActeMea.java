package ci.gouv.dgbf.domain.mea;

import ci.gouv.dgbf.domain.agc.Acte;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ACTE_BUDGETAIRE")
public class ActeMea implements Serializable {
    @Id
    @Column(name = "ACTE_ID")
    public String uuid;

    @Column(name = "ACTE_CAB_ID")
    public String categorieBudgetaireId;

    @Column(name = "EXO_NUM")
    public String exercice;

    @Column(name = "ACTE_NUMERO")
    public Integer numero;

    @Column(name = "ACTE_DATE_CREATION")
    public LocalDate created;

    @Column(name = "ACTE_DESIGNATION")
    public String libelle;

    @Column(name = "ACTE_REF_EXTERNE_ACTE")
    public String referenceExterne;

    @Column(name = "ACTE_SIGNATAIRE")
    public String signataire;

    @Column(name = "ACTE_DATE_SIGNATURE")
    public LocalDate dateSignature;

    @Column(name = "ACTE_DATE_MIS_EN_EXECUTION")
    public String dateMiseExecution;

    @Column(name = "ACTE_STATUT")
    public String statut;

    @Column(name = "DATE_CHANGEMENT_STATUT")
    public LocalDateTime dateChangementStatut;

    @Column(name = "ACTE_MIC_UTILISATEUR")
    public String utilisateur;

    @Lob
    @Column(name = "ACTE_COMMENTAIRE")
    public String commentaire;

    public ActeMea() {
    }

    public ActeMea(Acte acte) {
        this.uuid = acte.uuid;
        this.categorieBudgetaireId = UUID.randomUUID().toString();
        this.exercice = acte.exercice;
        this.numero = null;
        this.created = null;
        this.libelle = acte.libelle;
        this.referenceExterne = acte.reference;
        this.signataire = acte.signataire;
        this.dateSignature = null;
        this.statut = acte.statutActe.libelle;
        this.dateChangementStatut = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActeMea acteMea = (ActeMea) o;
        return Objects.equals(uuid, acteMea.uuid) && Objects.equals(categorieBudgetaireId, acteMea.categorieBudgetaireId) && Objects.equals(exercice, acteMea.exercice) && Objects.equals(numero, acteMea.numero) && Objects.equals(created, acteMea.created) && Objects.equals(libelle, acteMea.libelle) && Objects.equals(referenceExterne, acteMea.referenceExterne) && Objects.equals(signataire, acteMea.signataire) && Objects.equals(dateSignature, acteMea.dateSignature) && Objects.equals(dateMiseExecution, acteMea.dateMiseExecution) && Objects.equals(statut, acteMea.statut) && Objects.equals(dateChangementStatut, acteMea.dateChangementStatut) && Objects.equals(utilisateur, acteMea.utilisateur) && Objects.equals(commentaire, acteMea.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, categorieBudgetaireId, exercice, numero, created, libelle, referenceExterne, signataire, dateSignature, dateMiseExecution, statut, dateChangementStatut, utilisateur, commentaire);
    }

    @Override
    public String toString() {
        return "ActeMea{" +
                "uuid='" + uuid + '\'' +
                ", categorieBudgetaireId='" + categorieBudgetaireId + '\'' +
                ", exercice='" + exercice + '\'' +
                ", numero='" + numero + '\'' +
                ", created='" + created + '\'' +
                ", libelle='" + libelle + '\'' +
                ", referenceExterne='" + referenceExterne + '\'' +
                ", signataire='" + signataire + '\'' +
                ", dateSignature=" + dateSignature +
                ", dateMiseExecution=" + dateMiseExecution +
                ", statut='" + statut + '\'' +
                ", dateChangementStatut=" + dateChangementStatut +
                ", utilisateur='" + utilisateur + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
