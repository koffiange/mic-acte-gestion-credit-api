package ci.gouv.dgbf.dto;

import java.util.Objects;

public class Section{
    public String uuid;
    public String code;
    public String sigle;
    public String libelle;

    public Section() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(uuid, section.uuid) &&
                Objects.equals(code, section.code) &&
                Objects.equals(sigle, section.sigle) &&
                Objects.equals(libelle, section.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, code, sigle, libelle);
    }

    @Override
    public String toString() {
        return "Section{" +
                "uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                ", sigle='" + sigle + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
