package ci.gouv.dgbf.domain.agc;

import javax.persistence.*;

@Entity
@Table(name = "OPERATION_ACTE")
public class OperationActe {
    @Id
    @Column(name = "ID")
    public String uuid;
    @Column(name = "LDEP_ID")
    public String ligneDepenseId;
    @Column(name = "FIND_ID")
    public String financementId;
    @Column(name = "TYPE_ACTE")
    public String typeActeId;
    @Column(name = "TYPE_OPERATION")
    public String typeOperation;
    @Column(name = "MONTANT_AE")
    public String montantAe;
    @Column(name = "MONTANT_CP")
    public String montantCp;
    @Column(name = "ETAT")
    public String etat;
    @Column(name = "NATURE_ACTE")
    public String natureActe;
    @Column(name = "SENS_OPERATION")
    public String sensOperation;
    @Column(name = "EFFECTUE_PAR")
    public String effectuePar;
    @Column(name = "DATE_ACTE")
    public String dateActe;
    @Column(name = "CUMUL_ACTE_AE")
    public String cumulActeAe;
    @Column(name = "CUMUL_ACTE_CP")
    public String cumulActeCp;

    @ManyToOne
    @JoinColumn(name = "ACTE_ID")
    public ActeBudgetaire acteBudgetaire;


    public OperationActe() {
    }
}
