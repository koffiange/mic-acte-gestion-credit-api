package ci.gouv.dgbf.dto;

import ci.gouv.dgbf.domain.Acte;
import ci.gouv.dgbf.domain.Operation;
import ci.gouv.dgbf.domain.Signataire;

import java.util.List;
import java.util.Objects;

public class ActeDto {
    public Acte acte;
    public List<Signataire> signataireList;
    public List<Operation> operationList;
    public List<ImputationDto> imputationDtoList;

    public ActeDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActeDto acteDto = (ActeDto) o;
        return Objects.equals(acte, acteDto.acte) &&
                Objects.equals(signataireList, acteDto.signataireList) &&
                Objects.equals(operationList, acteDto.operationList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acte, signataireList, operationList);
    }

    @Override
    public String toString() {
        return "ActeDto{" +
                "acte=" + acte +
                ", signataireList=" + signataireList +
                ", operationList=" + operationList +
                ", imputationDtoList=" + imputationDtoList +
                '}';
    }
}
