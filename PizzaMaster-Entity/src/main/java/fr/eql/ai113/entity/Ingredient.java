package fr.eql.ai113.entity;

import java.io.Serializable;
import java.util.Date;

public class Ingredient implements Serializable {

    private Long ING_id;
    private String ING_intitule;
    private Short ING_complementaire;
    private Date ING_dateRetrait;
    private Long TYPEI_id;

    public Ingredient(long TYPEI_id, String ING_intitule, Short ING_complementaire) {
        this.TYPEI_id = TYPEI_id;
        this.ING_intitule = ING_intitule;
        this.ING_complementaire = ING_complementaire;
    }

    public long getING_id() {
        return ING_id;
    }

    public void setING_id(Long ING_id) {
        this.ING_id = ING_id;
    }

    public String getING_intitule() {
        return ING_intitule;
    }

    public void setING_intitule(String ING_intitule) {
        this.ING_intitule = ING_intitule;
    }

    public short getING_complementaire() {
        return ING_complementaire;
    }

    public void setING_complementaire(short ING_complementaire) {
        this.ING_complementaire = ING_complementaire;
    }

    public Date getING_dateRetrait() {
        return ING_dateRetrait;
    }

    public void setING_dateRetrait(Date ING_dateRetrait) {
        this.ING_dateRetrait = ING_dateRetrait;
    }

    public long getTYPEI_id() {
        return TYPEI_id;
    }

    public void setTYPEI_id(Long TYPEI_id) {
        this.TYPEI_id = TYPEI_id;
    }
}
