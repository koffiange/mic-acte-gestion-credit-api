package ci.gouv.dgbf.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "V_ACTIVITE_DE_SERVICE")
@Immutable
public class ActiviteDeService {
    @Id
    @Column(updatable = false, nullable = false)
    public String adsUuid;
    public String adsCode;
    public String adsLibelle;
    public String usbCode;
    public String usbLibelle;
    public String sectionCode;
    public String sectionLibelle;

    public ActiviteDeService() {
    }

    public ActiviteDeService(String adsUuid, String adsCode, String adsLibelle, String usbCode, String usbLibelle, String sectionCode, String sectionLibelle) {
        this.adsUuid = adsUuid;
        this.adsCode = adsCode;
        this.adsLibelle = adsLibelle;
        this.usbCode = usbCode;
        this.usbLibelle = usbLibelle;
        this.sectionCode = sectionCode;
        this.sectionLibelle = sectionLibelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiviteDeService that = (ActiviteDeService) o;
        return Objects.equals(adsUuid, that.adsUuid) && Objects.equals(adsCode, that.adsCode) && Objects.equals(adsLibelle, that.adsLibelle) && Objects.equals(usbCode, that.usbCode) && Objects.equals(usbLibelle, that.usbLibelle) && Objects.equals(sectionCode, that.sectionCode) && Objects.equals(sectionLibelle, that.sectionLibelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adsUuid, adsCode, adsLibelle, usbCode, usbLibelle, sectionCode, sectionLibelle);
    }

    @Override
    public String toString() {
        return "ActiviteDeService{" +
                "adsUuid='" + adsUuid + '\'' +
                ", adsCode='" + adsCode + '\'' +
                ", adsLibelle='" + adsLibelle + '\'' +
                ", usbCode='" + usbCode + '\'' +
                ", usbLibelle='" + usbLibelle + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                ", sectionLibelle='" + sectionLibelle + '\'' +
                '}';
    }
}
