package fr.eql.ai113.entity;

import java.io.Serializable;
import java.util.Date;

public class Stock implements Serializable {

    private long STO_id;
    private String STO_intitule;
    private int STO_quantite;
    private int STO_seuil;
    private Date STO_dateEntree;
    private String STO_description;
    private Date STO_dateRetrait;


    public Stock(String STO_intitule, int STO_quantite,
                 int STO_seuil, Date STO_dateEntree,
                 String STO_description, Date STO_dateRetrait) {
        this.STO_intitule = STO_intitule;
        this.STO_quantite = STO_quantite;
        this.STO_seuil = STO_seuil;
        this.STO_dateEntree = STO_dateEntree;
        this.STO_description = STO_description;
        this.STO_dateRetrait = STO_dateRetrait;
    }

    public String getSTO_intitule() {
        return STO_intitule;
    }

    public void setSTO_intitule(String STO_intitule) {
        this.STO_intitule = STO_intitule;
    }

    public int getSTO_quantite() {
        return STO_quantite;
    }

    public void setSTO_quantite(int STO_quantite) {
        this.STO_quantite = STO_quantite;
    }

    public int getSTO_seuil() {
        return STO_seuil;
    }

    public void setSTO_seuil(int STO_seuil) {
        this.STO_seuil = STO_seuil;
    }

    public Date getSTO_dateEntree() {
        return STO_dateEntree;
    }

    public void setSTO_dateEntree(Date STO_dateEntree) {
        this.STO_dateEntree = STO_dateEntree;
    }

    public String getSTO_description() {
        return STO_description;
    }

    public void setSTO_description(String STO_description) {
        this.STO_description = STO_description;
    }

    public Date getSTO_dateRetrait() {
        return STO_dateRetrait;
    }

    public void setSTO_dateRetrait(Date STO_dateRetrait) {
        this.STO_dateRetrait = STO_dateRetrait;
    }
}
