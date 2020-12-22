package ci.gouv.dgbf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Visa extends BaseEntity{
    public String code;
    @Column(length = 5000)
    public String intitule;

    public Visa() {
    }

    public Visa(String code, String intitule) {
        this.code = code;
        this.intitule = intitule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visa visa = (Visa) o;
        return Objects.equals(code, visa.code) &&
                Objects.equals(intitule, visa.intitule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, intitule);
    }

    @Override
    public String toString() {
        return "Visa{" +
                "code='" + code + '\'' +
                ", contenu='" + intitule + '\'' +
                '}';
    }
}
