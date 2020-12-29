package ci.gouv.dgbf.enumeration;

public enum NatureTransaction {
    VIREMENT("Virement"),
    TRANSFERT("Transfert");

    public String libelle;

    NatureTransaction(String libelle) {
        this.libelle = libelle;
    }
}
