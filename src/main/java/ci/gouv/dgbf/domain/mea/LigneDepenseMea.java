package ci.gouv.dgbf.domain.mea;

import ci.gouv.dgbf.domain.agc.Acte;
import ci.gouv.dgbf.domain.agc.LigneDepense;
import ci.gouv.dgbf.domain.agc.LigneOperation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "LIGNE_DE_DEPENSES")
public class LigneDepenseMea implements Serializable {
    @Id
    @Column(name = "LDEP_ID")
    public String uuid;

    @Column(name = "VERROU_ID")
    public String verrou;

    @Column(name = "EXO_NUM")
    public String exercice;

    @Column(name = "ACTE_ID")
    public String acteId;

    @Column(name = "ADS_ID")
    public String activiteServiceId;

    @Column(name = "NAT_ID")
    public String natureEconomiqueId;

    @Column(name = "ADP_ID")
    public String actionId;

    @Column(name = "GOUV_CODE")
    public String gouvernementCode;

    @Column(name = "SECB_ID")
    public String sectionId;

    @Column(name = "UA_ID")
    public String uaId;

    @Column(name = "NDEP_ID")
    public String natureDepenseId;

    @Column(name = "CATV_ID")
    public String catvId;

    @Column(name = "TYPE_CREDIT")
    public String typeCredit;

    @Column(name = "SYSTEME_EJ")
    public String systemeEJ;

    @Column(name = "TYPE_PROCEDURE")
    public String typeProcedure;

    @Column(name = "CBUD_ID")
    public String categorieBudget;

    @Column(name = "CARACTERE_REGLEMENTAIRE")
    public String caratereReglementaire = "N";

    @Column(name = "CARACTERE_MARCHE")
    public String caratereMarche = "N";

    public LigneDepenseMea() {
    }

    public LigneDepenseMea(LigneOperation ligneOperation, Acte acte){
        this.uuid = ligneOperation.ligneDepenseUuid;
        this.exercice = ligneOperation.exercice;
        this.acteId = acte.uuid;
        this.natureEconomiqueId = ligneOperation.natureEconomiqueId;
        this.activiteServiceId = ligneOperation.activiteId;
        this.actionId = ligneOperation.actionId;
        this.gouvernementCode = null;
        this.sectionId = ligneOperation.sectionId;
        this.natureDepenseId = ligneOperation.natureDepense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneDepenseMea that = (LigneDepenseMea) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(verrou, that.verrou) && Objects.equals(exercice, that.exercice) && Objects.equals(acteId, that.acteId) && Objects.equals(activiteServiceId, that.activiteServiceId) && Objects.equals(natureEconomiqueId, that.natureEconomiqueId) && Objects.equals(actionId, that.actionId) && Objects.equals(gouvernementCode, that.gouvernementCode) && Objects.equals(sectionId, that.sectionId) && Objects.equals(uaId, that.uaId) && Objects.equals(natureDepenseId, that.natureDepenseId) && Objects.equals(natureDepenseId, that.natureDepenseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, verrou, exercice, acteId, activiteServiceId, natureEconomiqueId, actionId, gouvernementCode, sectionId, uaId, natureDepenseId, natureDepenseId);
    }

    @Override
    public String toString() {
        return "LigneDepenseMea{" +
                "uuid='" + uuid + '\'' +
                ", verrou='" + verrou + '\'' +
                ", exercice='" + exercice + '\'' +
                ", acteId='" + acteId + '\'' +
                ", activiteServiceId='" + activiteServiceId + '\'' +
                ", natureEconomiqueId='" + natureEconomiqueId + '\'' +
                ", action='" + actionId + '\'' +
                ", gouvernementCode='" + gouvernementCode + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", uniteAdministrativeId='" + uaId + '\'' +
                ", natureDepense='" + natureDepenseId + '\'' +
                ", natureDepenseId='" + natureDepenseId + '\'' +
                '}';
    }
}
