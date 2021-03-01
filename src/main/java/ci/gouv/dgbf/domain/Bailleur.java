package ci.gouv.dgbf.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "V_BAILLEUR")
@Immutable
public class Bailleur {
    @Id
    public String bailleurId;
    public String bailleurCode;
    public String bailleurDesignation;

    public Bailleur() {
    }

    @Override
    public String toString() {
        return "Bailleur{" +
                "bailleurId='" + bailleurId + '\'' +
                ", bailleurCode='" + bailleurCode + '\'' +
                ", bailleurDesignation='" + bailleurDesignation + '\'' +
                '}';
    }
}
