package ci.gouv.dgbf.domain.mea;


import java.io.Serializable;
import java.util.Objects;

public class OperationMeaId implements Serializable {
    private String acteId;
    private String ligneDepenseId;
    private String financementId;

    public OperationMeaId() {
    }

    public OperationMeaId(String acteId, String ligneDepenseId, String financementId) {
        this.acteId = acteId;
        this.ligneDepenseId = ligneDepenseId;
        this.financementId = financementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationMeaId that = (OperationMeaId) o;
        return Objects.equals(acteId, that.acteId) && Objects.equals(ligneDepenseId, that.ligneDepenseId) && Objects.equals(financementId, that.financementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acteId, ligneDepenseId, financementId);
    }
}
