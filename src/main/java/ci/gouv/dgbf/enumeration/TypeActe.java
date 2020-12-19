package ci.gouv.dgbf.enumeration;

public enum TypeActe {
    ACTE_REGLEMENT("AR", "Acte de Règlement"),
    ACTE_LEGISLATIF("AL", "Acte de Législatif");

    public String code;
    public String libelle;

    TypeActe(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
}
