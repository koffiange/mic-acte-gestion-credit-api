package ci.gouv.dgbf.dto;

import java.util.Objects;

public class NatureEcnomique {
    public String code;
    public String libelleLong;
    public String sensComptable;

    public NatureEcnomique() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NatureEcnomique that = (NatureEcnomique) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(libelleLong, that.libelleLong) &&
                Objects.equals(sensComptable, that.sensComptable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelleLong, sensComptable);
    }

    @Override
    public String toString() {
        return "NatureEcnomique{" +
                "code='" + code + '\'' +
                ", libelleLong='" + libelleLong + '\'' +
                ", sensComptable='" + sensComptable + '\'' +
                '}';
    }
}
