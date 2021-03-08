package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.dto.ImputationDto;
import ci.gouv.dgbf.enumeration.KafkaStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Imputation extends PanacheEntityBase {
    @Id
    @Column(name = "ID")
    public String uuid;
    public String exercice;
    public String sectionCode;
    public String activiteId;
    public String natureEcnomiqueId;
    public String sourceFinancementId;
    public String bailleurId;
    @ManyToOne
    public Acte acte;


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

    public Imputation() {
    }

    public Imputation(String uuid, String exercice, String sectionCode, String activiteId, String natureEcnomiqueId, String sourceFinancementId, String bailleurId) {
        this.uuid = uuid;
        this.exercice = exercice;
        this.sectionCode = sectionCode;
        this.activiteId = activiteId;
        this.natureEcnomiqueId = natureEcnomiqueId;
        this.sourceFinancementId = sourceFinancementId;
        this.bailleurId = bailleurId;
    }

    public static Imputation parseImputationDto(ImputationDto dto){
        return new Imputation(dto.uuid, dto.exercice, dto.section.code, dto.activiteDeService.adsCode,
                              dto.natureEcnomique.code, dto.sourceFinancement.code, dto.bailleur.id);
    }

    @Override
    public String toString() {
        return "Imputation{" +
                "activiteId='" + activiteId + '\'' +
                ", natureEcnomiqueId='" + natureEcnomiqueId + '\'' +
                ", sourceFinancementId='" + sourceFinancementId + '\'' +
                ", bailleurId='" + bailleurId + '\'' +
                '}';
    }
}
