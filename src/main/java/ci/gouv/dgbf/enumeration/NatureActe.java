package ci.gouv.dgbf.enumeration;

public enum NatureActe {
    ARRETE("4", "Arrêté", "AR"),
    ARRETE_INTERMINISTERIEL("4", "Arrêté Interministériel", "Acte Règlementaire (AR)"),
    DECRET("3", "Décret","AL"),
    DECISION("5", "Décision","AR"),
    LOI("1","Loi", "AL"),
    ORDONNANCE("2", "Ordonnance", "AR");

    public String numero;
    public String libelle;
    public String typeActe;

    NatureActe(String numero, String libelle, String typeActe) {
        this.numero = numero;
        this.libelle = libelle;
        this.typeActe = typeActe;
    }
}
