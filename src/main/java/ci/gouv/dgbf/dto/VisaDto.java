package ci.gouv.dgbf.dto;

import ci.gouv.dgbf.domain.agc.Visa;

public class VisaDto {
    public Visa visa;
    public Integer numeroOrdre;

    public VisaDto() {
    }

    public VisaDto(Visa visa, Integer numeroOrdre) {
        this.visa = visa;
        this.numeroOrdre = numeroOrdre;
    }
}
