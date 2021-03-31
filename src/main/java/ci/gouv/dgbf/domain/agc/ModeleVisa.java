package ci.gouv.dgbf.domain.agc;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class ModeleVisa extends BaseEntity{
    public String code;
    public String libelle;
    public String description;

    public ModeleVisa() {
    }

    public ModeleVisa(String code, String libelle, String description) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeleVisa that = (ModeleVisa) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(libelle, that.libelle) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelle, description);
    }

    @Override
    public String toString() {
        return "ModeleVisa{" +
                "code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
