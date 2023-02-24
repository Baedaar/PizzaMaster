package fr.eql.ai113.entity;

public class LigneCommande {
    Integer LIGC_ID;
    Integer COM_reference;
    Integer PROD_ID;
    Integer LIGC_quantite;

    public LigneCommande(Integer LIGC_ID, Integer COM_reference, Integer PROD_ID, Integer LIGC_quantite) {
        this.LIGC_ID = LIGC_ID;
        this.COM_reference = COM_reference;
        this.PROD_ID = PROD_ID;
        this.LIGC_quantite = LIGC_quantite;
    }

    public Integer getLIGC_ID() {
        return LIGC_ID;
    }

    public void setLIGC_ID(Integer LIGC_ID) {
        this.LIGC_ID = LIGC_ID;
    }

    public Integer getCOM_reference() {
        return COM_reference;
    }

    public void setCOM_reference(Integer COM_reference) {
        this.COM_reference = COM_reference;
    }

    public Integer getPROD_ID() {
        return PROD_ID;
    }

    public void setPROD_ID(Integer PROD_ID) {
        this.PROD_ID = PROD_ID;
    }

    public Integer getLIGC_quantite() {
        return LIGC_quantite;
    }

    public void setLIGC_quantite(Integer LIGC_quantite) {
        this.LIGC_quantite = LIGC_quantite;
    }
}
