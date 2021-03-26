package ci.gouv.dgbf.enumeration;

public enum ActeRole {
    PAR_DEFAUT("Acte par défaut"),
    NON_SPECIFIE("Acte non par défaut");

    public String libelle;

    ActeRole(String libelle) {
        this.libelle = libelle;
    }
}
