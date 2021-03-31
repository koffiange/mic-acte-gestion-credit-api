package ci.gouv.dgbf.domain.agc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "LIGNE_DEPENSE_BIDF")
public class LigneDepenseBidf {
    @Id
    @Column(name = "ID")
    public String uuid;
    @Column(name = "ACTE_ID")
    public String acteId;
    @Column(name = "ADS_ID")
    public String adsId;
    @Column(name = "NAT_ID")
    public String natId;
    @Column(name = "USB_ID")
    public String usbId;
    @Column(name = "ADP_ID")
    public String adpId;
    @Column(name = "TYPE_CREDIT")
    public String typeCredit;
    @Column(name = "SYSTEME_EJ")
    public String systemEj;
    @Column(name = "ETAT")
    public String etat;
}
