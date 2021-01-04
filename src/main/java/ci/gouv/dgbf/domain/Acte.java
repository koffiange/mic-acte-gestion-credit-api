package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.CategorieActe;
import ci.gouv.dgbf.enumeration.NatureActe;
import ci.gouv.dgbf.enumeration.NatureTransaction;
import ci.gouv.dgbf.enumeration.StatutActe;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
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
    @Enumerated(value = EnumType.STRING)
    public NatureTransaction natureTransaction;
    public String reference;
    public LocalDate dateSignature;
    @ManyToOne
    public Demande demande;
    @ManyToOne
    public ModeleVisa modeleVisa;

    public Acte() {
    }
}
