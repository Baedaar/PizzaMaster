package fr.eql.ai113.entity;

import java.io.Serializable;
import java.util.Date;

public class Carte implements Serializable {
    private long CAR_id;
    private String CAR_intituleCategorie;
    private Date CAR_dateDebutVente;
    private Date CAR_dateFinVente;
    private float CAR_prixAjout;


    public Carte(String CAR_intituleCategorie, Date CAR_dateDebutVente, Date CAR_dateFinVente, float CAR_prixAjout) {
        this.CAR_intituleCategorie = CAR_intituleCategorie;
        this.CAR_dateDebutVente = CAR_dateDebutVente;
        this.CAR_dateFinVente = CAR_dateFinVente;
        this.CAR_prixAjout = CAR_prixAjout;
    }

    public String getCAR_intituleCategorie() {
        return CAR_intituleCategorie;
    }

    public void setCAR_intituleCategorie(String CAR_intituleCategorie) {
        this.CAR_intituleCategorie = CAR_intituleCategorie;
    }

    public Date getCAR_dateDebutVente() {
        return CAR_dateDebutVente;
    }

    public void setCAR_dateDebutVente(Date CAR_dateDebutVente) {
        this.CAR_dateDebutVente = CAR_dateDebutVente;
    }

    public Date getCAR_dateFinVente() {
        return CAR_dateFinVente;
    }

    public void setCAR_dateFinVente(Date CAR_dateFinVente) {
        this.CAR_dateFinVente = CAR_dateFinVente;
    }

    public float getCAR_prixAjout() {
        return CAR_prixAjout;
    }

    public void setCAR_prixAjout(float CAR_prixAjout) {
        this.CAR_prixAjout = CAR_prixAjout;
    }
}
