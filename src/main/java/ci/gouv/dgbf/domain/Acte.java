package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.enumeration.CategorieActe;
import ci.gouv.dgbf.enumeration.NatureActe;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Acte extends BaseEntity{
    public String corpus;
    @Enumerated(EnumType.STRING)
    public CategorieActe categorieActe;
    @Enumerated(EnumType.STRING)
    public NatureActe natureActe;
    public String reference;
    public LocalDate dateSignature;
    @ManyToOne
    public Demande demande;

    public Acte() {
    }
}
