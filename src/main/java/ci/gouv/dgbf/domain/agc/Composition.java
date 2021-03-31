package ci.gouv.dgbf.domain.agc;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Composition extends BaseEntity{
    public Integer numeroOrdre;

    @ManyToOne
    @JoinColumn(name = "visaId")
    public Visa visa;

    @ManyToOne
    @JoinColumn(name = "modeleVisaId")
    public ModeleVisa modeleVisa;

    public Composition() {
    }

    public Composition(ModeleVisa modeleVisa, Visa visa, Integer numeroOrdre) {
        this.modeleVisa = modeleVisa;
        this.visa = visa;
        this.numeroOrdre = numeroOrdre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composition that = (Composition) o;
        return Objects.equals(numeroOrdre, that.numeroOrdre) &&
                Objects.equals(visa, that.visa) &&
                Objects.equals(modeleVisa, that.modeleVisa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroOrdre, visa, modeleVisa);
    }

    @Override
    public String toString() {
        return "Composition{" +
                "numeroOrdre=" + numeroOrdre +
                ", visa=" + visa +
                ", modeleVisa=" + modeleVisa +
                '}';
    }
}
