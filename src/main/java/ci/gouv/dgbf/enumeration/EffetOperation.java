package ci.gouv.dgbf.enumeration;

public enum EffetOperation {
    RESERVATION("Réservation"),
    APPLICATION("Application");

    public String libelle;

    EffetOperation(String libelle) {
        this.libelle = libelle;
    }
}
