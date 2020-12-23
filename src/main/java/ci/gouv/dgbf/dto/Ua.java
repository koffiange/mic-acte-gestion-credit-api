package ci.gouv.dgbf.dto;

import javax.json.bind.annotation.JsonbProperty;

public class Ua{
    public String uuid;
    public String code;
    public String sigle;
    @JsonbProperty("libelleLong")
    public String libelle;

    public Ua() {
    }
}
