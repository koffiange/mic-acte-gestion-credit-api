package ci.gouv.dgbf.enumeration;

public enum  MotifReservation {
    ACTE_MOUVEMENT_CREDIT("Acte de mouvement de crédit"),
    AVANCE_DE_TRESORERIE("Avance de trésorerie (avec couverture de credit"),
    DEMANDE_ENGAGEMENT("Acte de mouvement de crédit"),
    MARCHE("Marché"),
    ORDRE_DE_PAYEMENT("Acte de mouvement de crédit");

    public String libelle;

    MotifReservation(String libelle) {
        this.libelle = libelle;
    }
}
