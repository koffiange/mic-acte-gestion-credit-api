package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.CategorieActe;
import ci.gouv.dgbf.enumeration.NatureActe;
import ci.gouv.dgbf.enumeration.NatureTransaction;
import ci.gouv.dgbf.enumeration.StatutActe;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NamedStoredProcedureQuery(
        name = "acte.copyIntoBIDF",
        procedureName = "COPY_AO_INTO_BIDF",
        parameters = {
                @StoredProcedureParameter(
                        name = "ACTE_ID",
                        mode = ParameterMode.IN,
                        type = String.class
                )
        })
public class Acte extends BaseEntity{
    public String referenceProjetActe;
    public String libelle;
    @Lob
    public String corpus;
    @Enumerated(EnumType.STRING)
    public CategorieActe categorieActe;
    @Enumerated(EnumType.STRING)
    public NatureActe natureActe;
    @Enumerated(EnumType.STRING)
    public StatutActe statutActe;
    @Enumerated(value = EnumType.STRING)
    public NatureTransaction natureTransaction;
    @Column(unique = true)
    public String reference;
    public LocalDate dateSignature;
    public String exercice;
    public BigDecimal cumulRetranchementAE;
    public BigDecimal cumulRetranchementCP;
    public BigDecimal cumulAjoutAE;
    public BigDecimal cumulAjoutCP;

    @ManyToOne
    public Demande demande;
    @ManyToOne
    public ModeleVisa modeleVisa;

    public Acte() {
    }

    @Override
    public String toString() {
        return "Acte{" +
                "libelle='" + libelle + '\'' +
                ", corpus='" + corpus + '\'' +
                ", categorieActe=" + categorieActe +
                ", natureActe=" + natureActe +
                ", statutActe=" + statutActe +
                ", natureTransaction=" + natureTransaction +
                ", reference='" + reference + '\'' +
                ", dateSignature=" + dateSignature +
                ", demande=" + demande +
                ", modeleVisa=" + modeleVisa +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
