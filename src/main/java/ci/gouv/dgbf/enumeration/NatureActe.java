package ci.gouv.dgbf.enumeration;

public enum NatureActe {
    LOI("1","Loi", "AL"),
    ORDONNANCE("2", "Ordonnance", "AR"),
    DECRET("3", "Décret","AL"),
    ARRETE("4", "Arrêté", "AR"),
    DECISION("5", "Décision","AR");

    public String numero;
    public String libelle;
    public String typeActe;

    NatureActe(String numero, String libelle, String typeActe) {
        this.numero = numero;
        this.libelle = libelle;
        this.typeActe = typeActe;
    }
}
