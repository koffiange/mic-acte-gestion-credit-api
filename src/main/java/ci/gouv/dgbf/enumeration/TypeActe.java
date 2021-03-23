package ci.gouv.dgbf.enumeration;

public enum TypeActe {
    LEGISLATIF("AL", "Acte de Législatif"),
    REGLEMENTAIRE("AR", "Acte de Règlement");

    public String code;
    public String libelle;

    TypeActe(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
}
