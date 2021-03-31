package ci.gouv.dgbf.dto;

import java.util.Objects;

public class NatureEconomique {
    public String uuid;
    public String code;
    public String libelleLong;
    public String sensComptable;
    public Boolean imputable;


    public NatureEconomique() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NatureEconomique that = (NatureEconomique) o;
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
        return "NatureEconomique{" +
                "code='" + code + '\'' +
                ", libelleLong='" + libelleLong + '\'' +
                ", sensComptable='" + sensComptable + '\'' +
                '}';
    }
}
