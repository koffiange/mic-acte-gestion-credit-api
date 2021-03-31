package ci.gouv.dgbf.domain.agc;

import ci.gouv.dgbf.dto.ImputationDto;
import ci.gouv.dgbf.enumeration.KafkaStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Imputation extends PanacheEntityBase {
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

    public Imputation() {
    }

    public static Imputation parseIntoImputation(ImputationDto imputationDto) {
        Imputation imputation = new Imputation();
        imputation.uuid = imputationDto.uuid;
        imputation.exercice = imputationDto.exercice;
        imputation.natureEconomiqueId = imputationDto.natureEconomique.uuid;
        imputation.natureEconomiqueCode = imputationDto.natureEconomique.code;
        imputation.natureEconomiqueLibelle = imputationDto.natureEconomique.libelleLong;
        imputation.usbCode = imputationDto.activiteDeService.usbCode;
        imputation.usbLibelle = imputationDto.activiteDeService.usbLibelle;
        imputation.sectionId = imputationDto.section.uuid;
        imputation.sectionCode = imputationDto.section.code;
        imputation.sectionLibelle = imputationDto.section.libelle;
        imputation.activiteId = imputationDto.activiteDeService.adsUuid;
        imputation.activiteCode = imputationDto.activiteDeService.adsCode;;
        imputation.activiteLibelle = imputationDto.activiteDeService.adsLibelle;;
        imputation.actionId = null;
        imputation.actionCode = null;
        imputation.actionLibelle = null;
        imputation.uaId = null;
        imputation.bailleurId = imputationDto.bailleur.id;
        imputation.bailleurLibelle = imputationDto.bailleur.designation;
        imputation.sourceFinancementId = imputationDto.sourceFinancement.id;
        imputation.sourceFinancementCode = imputationDto.sourceFinancement.code;
        imputation.sourceFinancementLibelle = imputationDto.sourceFinancement.libelle;
        imputation.montantAe = imputationDto.montantAe;
        imputation.montantCp = imputationDto.montantCp;
        imputation.montantDisponibleAE = imputationDto.montantAe;
        imputation.montantDisponibleCP = imputationDto.montantCp;
        imputation.natureDepense = null;
        return imputation;
    }
}
