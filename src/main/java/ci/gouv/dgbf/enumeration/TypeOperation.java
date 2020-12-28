package ci.gouv.dgbf.enumeration;

public enum TypeOperation {
    ORIGINE("Opération d'origine"),
    DESTINATION("Opération de destination");

    public String libelle;

    TypeOperation(String libelle) {
        this.libelle = libelle;
    }
}
