package ci.gouv.dgbf.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "V_SOURCE_FINANCEMENT")
@Immutable
public class SourceFinancement {
    @Id
    @Column(name = "SOURCEFINANCEMENTID")
    public String id;
    @Column(name = "SOURCEFINANCEMENTCODE")
    public String code;
    @Column(name = "SOURCEFINANCEMENTLIBELLE")
    public String libelle;

    public SourceFinancement() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceFinancement that = (SourceFinancement) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, libelle);
    }

    @Override
    public String toString() {
        return "SourceFinancement{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
