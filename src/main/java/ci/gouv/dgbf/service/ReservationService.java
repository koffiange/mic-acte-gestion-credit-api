package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Operation;
import ci.gouv.dgbf.domain.Reservation;
import ci.gouv.dgbf.enumeration.MotifReservation;
import ci.gouv.dgbf.enumeration.StatutReservation;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ReservationService  implements PanacheRepositoryBase<Reservation, String> {
    public void persistReservationOfOperation(List<Operation> operationList){
        operationList.stream().map(Reservation::new).forEach(reservation -> reservation.persist());
    }

    public void dereserverParOperation(List<Operation> operationList){
        operationList.stream().map(operation -> operation.uuid).forEach(this::dereserver);
    }

    public void dereserver(String operationUuid){
        Map<String, Object> params = new HashMap<>();
        params.put("motifReservation", MotifReservation.ACTE_MOUVEMENT_CREDIT);
        params.put("motifReservationId", operationUuid);
        params.put("statutReservation", StatutReservation.CONSOMMEE);
        Reservation.update("statutReservation = :statutReservation " +
                "WHERE motifReservation = :motifReservation " +
                "AND motifReservationId = :motifReservationId ", params);
    }
}
