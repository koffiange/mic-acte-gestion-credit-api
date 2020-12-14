package ci.gouv.dgbf.domain;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class NatureActe extends BaseEntity{
    public String code;
    public String libelle;

    public NatureActe() {
    }

    public NatureActe(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NatureActe that = (NatureActe) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelle);
    }

    @Override
    public String toString() {
        return "NatureActe{" +
                "code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
