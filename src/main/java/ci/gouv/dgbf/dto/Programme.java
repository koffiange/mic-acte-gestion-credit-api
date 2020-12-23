package ci.gouv.dgbf.dto;

import javax.json.bind.annotation.JsonbProperty;

public class Programme{
    public String uuid;
    public String code;
    @JsonbProperty("libelleLong")
    public String libelle;

    public Programme() {
    }
}
