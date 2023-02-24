package fr.eql.ai113.entity;

import java.io.Serializable;

public class Adresse extends Lieu implements Serializable {
    private long ADD_id;

    private long CLI_id;
    private int ADD_numeroRue;
    private String ADD_nomVoie;
    private String ADD_escalier;
    private short ADD_etage;
    private String ADD_porte;


    public Adresse(long ADD_id,long CLI_id,int ADD_numeroRue, String ADD_nomVoie, String ADD_escalier, short ADD_etage, String ADD_porte,long LIE_id, String LIE_ville, String LIE_codePostal) {
        super(LIE_id,LIE_ville, LIE_codePostal);
        this.ADD_id = ADD_id;
        this.CLI_id = CLI_id;
        this.ADD_numeroRue = ADD_numeroRue;
        this.ADD_nomVoie = ADD_nomVoie;
        this.ADD_escalier = ADD_escalier;
        this.ADD_etage = ADD_etage;
        this.ADD_porte = ADD_porte;
    }

    public int getADD_numeroRue() {
        return ADD_numeroRue;
    }

    public void setADD_numeroRue(int ADD_numeroRue) {
        this.ADD_numeroRue = ADD_numeroRue;
    }

    public String getADD_nomVoie() {
        return ADD_nomVoie;
    }

    public void setADD_nomVoie(String ADD_nomVoie) {
        this.ADD_nomVoie = ADD_nomVoie;
    }

    public String getADD_escalier() {
        return ADD_escalier;
    }

    public void setADD_escalier(String ADD_escalier) {
        this.ADD_escalier = ADD_escalier;
    }

    public short getADD_etage() {
        return ADD_etage;
    }

    public void setADD_etage(short ADD_etage) {
        this.ADD_etage = ADD_etage;
    }

    public String getADD_porte() {
        return ADD_porte;
    }

    public void setADD_porte(String ADD_porte) {
        this.ADD_porte = ADD_porte;
    }

    public long getADD_id() {
        return ADD_id;
    }

    public void setADD_id(long ADD_id) {
        this.ADD_id = ADD_id;
    }


    public long getCLI_id() {
        return CLI_id;
    }

    public void setCLI_id(long CLI_id) {
        this.CLI_id = CLI_id;
    }
}
