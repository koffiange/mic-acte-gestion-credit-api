package ci.gouv.dgbf.domain;

import javax.persistence.Entity;

@Entity
public class Exercice extends BaseEntity{
    public String annee;

    public Exercice() {
    }

    public Exercice(String annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Exercice{" +
                "annee='" + annee + '\'' +
                '}';
    }
}
