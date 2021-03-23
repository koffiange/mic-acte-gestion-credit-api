package ci.gouv.dgbf.enumeration;

public enum NatureActe {
    LOI("1","Loi", "LOI", "Acte Législatif (AL)"),
    ORDONNANCE("2", "Ordonnance", "ORDONNANCE", "Acte Règlementaire (AR)"),
    DECRET("3", "Décret", "DECRET", "Acte Législatif (AL)"),
    ARRETE_MINISTERIEL("4", "Arrêté Ministériel", "ARRETE_MINISTERIEL", "Acte Règlementaire (AR)"),
    ARRETE_INTERMINISTERIEL("5", "Arrêté Interministériel", "ARRETE_INTERMINISTERIEL", "Acte Règlementaire (AR)"),
    DECISION("6", "Décision", "DECISION", "Acte Règlementaire (AR)"),
    AUTRE_ACTE("7", "Autre", "AUTRE_ACTE", "Acte Règlementaire (AR)");

    public String numero;
    public String libelle;
    public String valeur;
    public String typeActe;

    NatureActe(String numero, String libelle, String valeur, String typeActe) {
        this.numero = numero;
        this.libelle = libelle;
        this.valeur = valeur;
        this.typeActe = typeActe;
    }
}
