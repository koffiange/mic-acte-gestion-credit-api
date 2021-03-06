package ci.gouv.dgbf.domain.agc;

import ci.gouv.dgbf.enumeration.*;

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
    public String libelle;
    @Lob
    public String corpus;
    @Enumerated(EnumType.STRING)
    public CategorieActe categorieActe;
    @Enumerated(EnumType.STRING)
    public NatureActe natureActe;
    @Enumerated(EnumType.STRING)
    public StatutActe statutActe;
    public LocalDateTime dateChangementStatut;
    @Enumerated(value = EnumType.STRING)
    public NatureTransaction natureTransaction;
    @Column(unique = true)
    public String reference;
    public LocalDate dateSignature;
    public String signataire;
    public String exercice;
    public BigDecimal cumulRetranchementAE;
    public BigDecimal cumulRetranchementCP;
    public BigDecimal cumulAjoutAE;
    public BigDecimal cumulAjoutCP;
    @Enumerated(value = EnumType.STRING)
    public ActeRole acteParDefaut;

    @ManyToOne
    public Demande demande;
    @ManyToOne
    public ModeleVisa modeleVisa;
    @ManyToOne
    @JoinColumn(name = "OPERATION_ID")
    public Operation operation;

    public Acte() {
    }

    @Override
    public String toString() {
        return "Acte{" +
                ", libelle='" + libelle + '\'' +
                ", corpus='" + corpus + '\'' +
                ", categorieActe=" + categorieActe +
                ", natureActe=" + natureActe +
                ", statutActe=" + statutActe +
                ", natureTransaction=" + natureTransaction +
                ", reference='" + reference + '\'' +
                ", dateSignature=" + dateSignature +
                ", exercice='" + exercice + '\'' +
                ", cumulRetranchementAE=" + cumulRetranchementAE +
                ", cumulRetranchementCP=" + cumulRetranchementCP +
                ", cumulAjoutAE=" + cumulAjoutAE +
                ", cumulAjoutCP=" + cumulAjoutCP +
                ", acteParDefaut=" + acteParDefaut +
                ", demande=" + demande +
                ", modeleVisa=" + modeleVisa +
                ", operation=" + operation +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
