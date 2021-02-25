package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.MotifReservation;
import ci.gouv.dgbf.enumeration.StatutReservation;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Reservation extends BaseEntity{
    public BigDecimal montantAE;
    public BigDecimal montantCP;
    @Enumerated(EnumType.STRING)
    public StatutReservation statutReservation;
    @Enumerated(EnumType.STRING)
    public MotifReservation motifReservation;
    public String motifReservationId;

    public Reservation() {
    }

    public Reservation(Operation operation) {
        this.montantAE = operation.montantOperationAE;
        this.montantCP = operation.montantOperationCP;
        this.statutReservation = StatutReservation.EN_ATTENTE_CONSOMMATION;
        this.motifReservation = MotifReservation.ACTE_MOUVEMENT_CREDIT;
        this.motifReservationId = operation.acte.uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(montantAE, that.montantAE) &&
                Objects.equals(montantCP, that.montantCP) &&
                statutReservation == that.statutReservation &&
                motifReservation == that.motifReservation &&
                Objects.equals(motifReservationId, that.motifReservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(montantAE, montantCP, statutReservation, motifReservation, motifReservationId);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "montantAE=" + montantAE +
                ", montantCP=" + montantCP +
                ", statutReservation=" + statutReservation +
                ", motifReservation=" + motifReservation +
                ", motifReservationId='" + motifReservationId + '\'' +
                '}';
    }
}
