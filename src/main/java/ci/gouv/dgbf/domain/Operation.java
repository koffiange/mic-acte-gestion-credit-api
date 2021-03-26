package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.StatutActe;
import ci.gouv.dgbf.enumeration.StatutOperation;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Operation extends BaseEntity{
    public String codeOperation;
    public BigDecimal variationAE;
    public BigDecimal variationCP;
    public StatutOperation statutOperation;
    public String exercice;

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
