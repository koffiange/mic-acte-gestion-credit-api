package ci.gouv.dgbf.domain.agc;

import ci.gouv.dgbf.enumeration.KafkaStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Imputation_old extends PanacheEntityBase {
    @Id
    @Column(name = "ID")
    public String uuid;
    public String exercice;
    public String natureEconomiqueId;
    public String natureEconomiqueCode;
    public String natureEconomiqueLibelle;
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
    public String uaId;
    public String bailleurId;
    public String bailleurLibelle;
    public String sourceFinancementId;
    public String sourceFinancementCode;
    public String sourceFinancementLibelle;
    public BigDecimal montantAe;
    public BigDecimal montantCp;
    public BigDecimal montantDisponibleAE;
    public BigDecimal montantDisponibleCP;
    public String natureDepense;
    @Column(name = "CREATED")
    public LocalDateTime createdDate = LocalDateTime.now();
    @Column(name = "UPDATED")
    public LocalDateTime updatedDate;
    @Column(name = "CREATED_BY")
    public String createdBy;
    @Column(name = "UPDATED_BY")
    public String updatedBy;
    @Column(name = "KAFKA_STATUS")
    @JsonbTransient
    public KafkaStatus kafkaStatus = KafkaStatus.COMMITTED;

    @ManyToOne
    @JoinColumn(name = "ACTE_ID")
    public Acte acte;


    public Imputation_old() {
    }

    /*
    public Imputation_old(ImputationDto imputationDto, Acte acte) {
        this.uuid = imputationDto.uuid;
        this.exercice = imputationDto.exercice;
        this.natureEconomiqueId = imputationDto.natureEconomique.uuid;
        this.natureEconomiqueCode = imputationDto.natureEconomique.code;
        this.natureEconomiqueLibelle = imputationDto.natureEconomique.libelleLong;
        this.usbCode = imputationDto.activiteDeService.usbCode;
        this.usbLibelle = imputationDto.activiteDeService.usbLibelle;
        this.sectionId = imputationDto.section.uuid;
        this.sectionCode = imputationDto.section.code;
        this.sectionLibelle = imputationDto.section.libelle;
        this.activiteId = imputationDto.activiteDeService.adsUuid;
        this.activiteCode = imputationDto.activiteDeService.adsCode;;
        this.activiteLibelle = imputationDto.activiteDeService.adsLibelle;;
        this.actionId = null;
        this.actionCode = null;
        this.actionLibelle = null;
        this.uaId = uaId;
        this.bailleurId = imputationDto.bailleur.id;
        this.bailleurLibelle = imputationDto.bailleur.designation;
        this.sourceFinancementId = imputationDto.sourceFinancement.id;
        this.sourceFinancementCode = imputationDto.sourceFinancement.code;
        this.sourceFinancementLibelle = imputationDto.sourceFinancement.libelle;
        this.montantAe = imputationDto.montantAe;
        this.montantCp = imputationDto.montantCp;
        this.montantDisponibleAE = imputationDto.montantAe;
        this.montantDisponibleCP = imputationDto.montantCp;
        this.natureDepense = null;
        this.acte = acte;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imputation_old that = (Imputation_old) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(exercice, that.exercice) && Objects.equals(natureEconomiqueId, that.natureEconomiqueId) && Objects.equals(natureEconomiqueCode, that.natureEconomiqueCode) && Objects.equals(natureEconomiqueLibelle, that.natureEconomiqueLibelle) && Objects.equals(usbCode, that.usbCode) && Objects.equals(usbLibelle, that.usbLibelle) && Objects.equals(sectionId, that.sectionId) && Objects.equals(sectionCode, that.sectionCode) && Objects.equals(sectionLibelle, that.sectionLibelle) && Objects.equals(activiteId, that.activiteId) && Objects.equals(activiteCode, that.activiteCode) && Objects.equals(activiteLibelle, that.activiteLibelle) && Objects.equals(actionId, that.actionId) && Objects.equals(actionCode, that.actionCode) && Objects.equals(actionLibelle, that.actionLibelle) && Objects.equals(uaId, that.uaId) && Objects.equals(bailleurId, that.bailleurId) && Objects.equals(bailleurLibelle, that.bailleurLibelle) && Objects.equals(sourceFinancementId, that.sourceFinancementId) && Objects.equals(sourceFinancementCode, that.sourceFinancementCode) && Objects.equals(sourceFinancementLibelle, that.sourceFinancementLibelle) && Objects.equals(montantAe, that.montantAe) && Objects.equals(montantCp, that.montantCp) && Objects.equals(montantDisponibleAE, that.montantDisponibleAE) && Objects.equals(montantDisponibleCP, that.montantDisponibleCP) && Objects.equals(natureDepense, that.natureDepense) && Objects.equals(acte, that.acte) && Objects.equals(createdDate, that.createdDate) && Objects.equals(updatedDate, that.updatedDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedBy, that.updatedBy) && kafkaStatus == that.kafkaStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, exercice, natureEconomiqueId, natureEconomiqueCode, natureEconomiqueLibelle, usbCode, usbLibelle, sectionId, sectionCode, sectionLibelle, activiteId, activiteCode, activiteLibelle, actionId, actionCode, actionLibelle, uaId, bailleurId, bailleurLibelle, sourceFinancementId, sourceFinancementCode, sourceFinancementLibelle, montantAe, montantCp, montantDisponibleAE, montantDisponibleCP, natureDepense, acte, createdDate, updatedDate, createdBy, updatedBy, kafkaStatus);
    }

    @Override
    public String toString() {
        return "Imputation_old{" +
                "uuid='" + uuid + '\'' +
                ", exercice='" + exercice + '\'' +
                ", natureEconomiqueId='" + natureEconomiqueId + '\'' +
                ", natureEconomiqueCode='" + natureEconomiqueCode + '\'' +
                ", natureEconomiqueLibelle='" + natureEconomiqueLibelle + '\'' +
                ", usbCode='" + usbCode + '\'' +
                ", usbLibelle='" + usbLibelle + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                ", sectionLibelle='" + sectionLibelle + '\'' +
                ", activiteId='" + activiteId + '\'' +
                ", activiteCode='" + activiteCode + '\'' +
                ", activiteLibelle='" + activiteLibelle + '\'' +
                ", actionId='" + actionId + '\'' +
                ", actionCode='" + actionCode + '\'' +
                ", actionLibelle='" + actionLibelle + '\'' +
                ", uaId='" + uaId + '\'' +
                ", bailleurId='" + bailleurId + '\'' +
                ", bailleurLibelle='" + bailleurLibelle + '\'' +
                ", sourceFinancementId='" + sourceFinancementId + '\'' +
                ", sourceFinancementCode='" + sourceFinancementCode + '\'' +
                ", sourceFinancementLibelle='" + sourceFinancementLibelle + '\'' +
                ", montantAe=" + montantAe +
                ", montantCp=" + montantCp +
                ", montantDisponibleAE=" + montantDisponibleAE +
                ", montantDisponibleCP=" + montantDisponibleCP +
                ", natureDepense='" + natureDepense + '\'' +
                ", acte=" + acte +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", kafkaStatus=" + kafkaStatus +
                '}';
    }
}
