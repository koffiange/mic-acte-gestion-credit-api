package ci.gouv.dgbf.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Signataire extends BaseEntity{
    public String fonction;
    public String nom;
    @ManyToOne
    public Acte acte;

    public Signataire() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signataire that = (Signataire) o;
        return Objects.equals(fonction, that.fonction) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(acte, that.acte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fonction, nom, acte);
    }

    @Override
    public String toString() {
        return "Signataire{" +
                "fonction='" + fonction + '\'' +
                ", nom='" + nom + '\'' +
                ", acte=" + acte +
                '}';
    }
}
