package ci.gouv.dgbf.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "V_LIGNE_DETAIL_EXECUTION")
@Immutable
public class LigneDepenseExecution {
    @Id
    @Column(updatable = false, nullable = false)
    public String ligneDepenseId = UUID.randomUUID().toString();
    public BigDecimal montantDisponibleAe;
    public BigDecimal montantDisponibleCp;
    public String ligneStatut;
    public String exercice;
    public String activiteCode;
    public String natureeconomiqueCode;
    public String bailleurId;

    public LigneDepenseExecution() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneDepenseExecution that = (LigneDepenseExecution) o;
        return Objects.equals(montantDisponibleAe, that.montantDisponibleAe) && Objects.equals(montantDisponibleCp, that.montantDisponibleCp) && Objects.equals(ligneStatut, that.ligneStatut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(montantDisponibleAe, montantDisponibleCp, ligneStatut);
    }

    @Override
    public String toString() {
        return "LigneDepenseExecution{" +
                "montantDisponibleAe=" + montantDisponibleAe +
                ", montantDisponibleCp=" + montantDisponibleCp +
                ", ligneStatut='" + ligneStatut + '\'' +
                '}';
    }
}
