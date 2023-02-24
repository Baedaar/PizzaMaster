package fr.eql.ai113.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lieu implements Serializable {

    private long LIE_id;
    private String LIE_ville;
    private String LIE_codePostal;
    private List<Site> sites = new ArrayList<>();
    private List<Lieu> lieu = new ArrayList<>();

    public Lieu(long LIE_id, String LIE_ville, String LIE_codePostal) {
        this.LIE_id = LIE_id;
        this.LIE_ville = LIE_ville;
        this.LIE_codePostal = LIE_codePostal;
    }
    public Lieu() {

    }

    public Lieu(Long LIE_id) {
        this.LIE_id =LIE_id;

    }


    public String getLIE_ville() {
        return LIE_ville;
    }

    public void setLIE_ville(String LIE_ville) {
        this.LIE_ville = LIE_ville;
    }

    public String getLIE_codePostal() {
        return LIE_codePostal;
    }

    public void setLIE_codePostal(String LIE_codePostal) {
        this.LIE_codePostal = LIE_codePostal;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public List<Site> getsites(){
        return sites;
    }

    public Lieu getLieu(Lieu lieu) {
        return lieu;
    }

    public long getLIE_id() {
        return LIE_id;
    }

    public void setLIE_id(long LIE_id) {
        this.LIE_id = LIE_id;
    }

}


