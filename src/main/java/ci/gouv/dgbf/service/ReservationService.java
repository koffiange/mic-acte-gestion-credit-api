package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.LigneOperation;
import ci.gouv.dgbf.domain.Reservation;
import ci.gouv.dgbf.enumeration.MotifReservation;
import ci.gouv.dgbf.enumeration.StatutReservation;
import ci.gouv.dgbf.enumeration.TypeOperation;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ReservationService  implements PanacheRepositoryBase<Reservation, String> {
    public void persistReservationOfOperation(List<LigneOperation> ligneOperationList){
        ligneOperationList.stream().filter(operation -> operation.typeOperation.equals(TypeOperation.ORIGINE)).map(Reservation::new).forEach(reservation -> reservation.persist());
    }

    public void dereserverParOperation(List<LigneOperation> ligneOperationList){
        ligneOperationList.stream().map(operation -> operation.uuid).forEach(this::dereserver);
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

    public void deleteByActe(String uuid){
        delete("motifReservationId", uuid);
    }
}
