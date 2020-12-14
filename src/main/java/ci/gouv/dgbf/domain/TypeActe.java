package ci.gouv.dgbf.domain;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class TypeActe extends BaseEntity{
    public String code;
    public String libelle;

    public TypeActe() {
    }

    public TypeActe(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeActe typeActe = (TypeActe) o;
        return Objects.equals(code, typeActe.code) &&
                Objects.equals(libelle, typeActe.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelle);
    }

    @Override
    public String toString() {
        return "TypeActe{" +
                "code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
