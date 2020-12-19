package ci.gouv.dgbf.enumeration;

public enum StatutDemande {
    REFUSE("Refusée"),
    DIFFERE("Diferée"),
    VALIDER("Validée");

    public String libelle;

    StatutDemande(String libelle) {
        this.libelle = libelle;
    }
}
