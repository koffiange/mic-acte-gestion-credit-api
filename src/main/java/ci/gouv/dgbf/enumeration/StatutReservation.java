package ci.gouv.dgbf.enumeration;

public enum StatutReservation {
    EN_ATTENTE_CONSOMMATION("En attente de consommation"),
    CONSOMMEE("Réservation consommée");

    public String libelle;

    StatutReservation(String libelle) {
        this.libelle = libelle;
    }
}
