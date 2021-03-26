package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.StatutActe;
import ci.gouv.dgbf.enumeration.StatutOperation;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
public class Operation extends BaseEntity{
    public String codeOperation;
    public BigDecimal variationAE;
    public BigDecimal variationCP;
    @Enumerated(EnumType.STRING)
    public StatutOperation statutOperation;
    public String exercice;

    public Operation() {
    }

    @Override
    public String toString() {
        return "Operation{" +
                "uuid='" + uuid + '\'' +
                ", codeOperation='" + codeOperation + '\'' +
                ", variationAE=" + variationAE +
                ", variationCP=" + variationCP +
                ", statutOperation=" + statutOperation +
                ", exercice='" + exercice + '\'' +
                '}';
    }
}
