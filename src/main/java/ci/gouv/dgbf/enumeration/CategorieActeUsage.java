package ci.gouv.dgbf.enumeration;

public enum CategorieActeUsage {
    BUDGETISATION("Budgétisation"),
    GESTION("Gestion");

    public String libelle;

    CategorieActeUsage(String libelle) {
        this.libelle = libelle;
    }
}
