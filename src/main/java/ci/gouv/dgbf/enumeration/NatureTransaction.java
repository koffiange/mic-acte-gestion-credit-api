package ci.gouv.dgbf.enumeration;

public enum NatureTransaction {
    VIREMENT("Virement"),
    TRANSFERT("Transfert");

    public String value;

    NatureTransaction(String value) {
        this.value = value;
    }
}
