package ci.gouv.dgbf.domain.agc;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "V_CATEGORIE_ACTE_BUDGETAIRE")
@Immutable
public class CategorieActeBudgetaire {
    @Id
    @Column(updatable = false, nullable = false)
    public String uuid;
    public String designation;
    public String natureActe;
    public String usageType;
    public String acteType;

    public CategorieActeBudgetaire() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieActeBudgetaire that = (CategorieActeBudgetaire) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(designation, that.designation) && Objects.equals(natureActe, that.natureActe) && Objects.equals(usageType, that.usageType) && Objects.equals(acteType, that.acteType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, designation, natureActe, usageType, acteType);
    }

    @Override
    public String toString() {
        return "CategorieActeBudgetaire{" +
                "uuid='" + uuid + '\'' +
                ", designation='" + designation + '\'' +
                ", groupe='" + natureActe + '\'' +
                ", usage='" + usageType + '\'' +
                ", typeActe='" + acteType + '\'' +
                '}';
    }
}
