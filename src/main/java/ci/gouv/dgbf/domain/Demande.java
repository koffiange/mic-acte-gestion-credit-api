package ci.gouv.dgbf.domain;

import ci.gouv.dgbf.dto.Section;
import ci.gouv.dgbf.enumeration.StatutDemande;
import ci.gouv.dgbf.enumeration.TypeDemande;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

@Entity
public class Demande extends BaseEntity{
    @Enumerated(EnumType.STRING)
    public TypeDemande typeDemande;
    @Lob
    public String contenu;
    @Enumerated(EnumType.STRING)
    public StatutDemande statutDemande;

    public String demandeurSectionCode;
    public String demandeurSectionLibelle;
    public String demandeurUaCode;
    public String demandeurUaLibelle;

    public Demande() {
    }
}
