package ci.gouv.dgbf.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "V_BAILLEUR")
@Immutable
public class Bailleur {
    @Id
    @Column(name = "BAILLEURID")
    public String id;
    @Column(name = "BAILLEURCODE")
    public String code;
    @Column(name = "BAILLEURDESIGNATION")
    public String designation;

    public Bailleur() {
    }

    @Override
    public String toString() {
        return "Bailleur{" +
                "bailleurId='" + id + '\'' +
                ", bailleurCode='" + code + '\'' +
                ", bailleurDesignation='" + designation + '\'' +
                '}';
    }
}
