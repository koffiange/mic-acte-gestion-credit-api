package ci.gouv.dgbf.dto;

import ci.gouv.dgbf.domain.agc.Acte;
import ci.gouv.dgbf.domain.agc.LigneOperation;
import ci.gouv.dgbf.domain.agc.Operation;
import ci.gouv.dgbf.domain.agc.Signataire;

import java.util.List;
import java.util.Objects;

public class OperationBag {
    public Acte acte;
    public List<Signataire> signataireList;
    public Operation operation;
    public List<LigneOperation> ligneOperationList;
    public List<ImputationDto> imputationDtoList;

    public OperationBag() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationBag that = (OperationBag) o;
        return Objects.equals(acte, that.acte) && Objects.equals(operation, that.operation) && Objects.equals(ligneOperationList, that.ligneOperationList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acte, operation, ligneOperationList);
    }

    @Override
    public String toString() {
        return "OperationBag{" +
                ", acte=" + acte +
                ", operation=" + operation +
                ", ligneOperationList=" + ligneOperationList +
                ", imputationDtoList=" + imputationDtoList +
                '}';
    }
}
