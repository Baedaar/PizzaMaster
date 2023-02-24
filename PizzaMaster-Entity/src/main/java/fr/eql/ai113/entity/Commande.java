package fr.eql.ai113.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Commande {
    Integer COM_REFERENCE;
    Integer TAU_ID;
    Integer MODER_ID;
    Integer CAR_ID;
    Integer LIV_ID;
    Integer MODP_ID;
    Integer SIT_ID;
    LocalDate COM_date;
    LocalDate COM_dateHeureValide;
    LocalTime COM_heureDebutPrepa;
    LocalTime COM_heureFinPrepa;
    LocalTime COM_heurePriseCommande;
    LocalTime COM_heureRemiseCommandeLivreur;
    LocalTime COM_heureValidationPaiement;
    LocalTime COM_heureFinDeLivraison;

    public Commande(Integer TAU_ID, Integer MODER_ID, Integer CAR_ID, Integer LIV_ID, Integer MODP_ID, Integer SIT_ID, LocalDate COM_date, LocalDate COM_dateHeureValide, LocalTime COM_heureDebutPrepa, LocalTime COM_heureFinPrepa, LocalTime COM_heurePriseCommande, LocalTime COM_heureRemiseCommandeLivreur, LocalTime COM_heureValidationPaiement, LocalTime COM_heureFinDeLivraison) {
        this.TAU_ID = TAU_ID;
        this.MODER_ID = MODER_ID;
        this.CAR_ID = CAR_ID;
        this.LIV_ID = LIV_ID;
        this.MODP_ID = MODP_ID;
        this.SIT_ID = SIT_ID;
        this.COM_date = COM_date;
        this.COM_dateHeureValide = COM_dateHeureValide;
        this.COM_heureDebutPrepa = COM_heureDebutPrepa;
        this.COM_heureFinPrepa = COM_heureFinPrepa;
        this.COM_heurePriseCommande = COM_heurePriseCommande;
        this.COM_heureRemiseCommandeLivreur = COM_heureRemiseCommandeLivreur;
        this.COM_heureValidationPaiement = COM_heureValidationPaiement;
        this.COM_heureFinDeLivraison = COM_heureFinDeLivraison;
    }

    public Commande(Integer COM_REFERENCE, Integer TAU_ID, Integer MODER_ID, Integer CAR_ID, Integer LIV_ID, Integer MODP_ID, Integer SIT_ID, LocalDate COM_date, LocalDate COM_dateHeureValide, LocalTime COM_heureDebutPrepa, LocalTime COM_heureFinPrepa, LocalTime COM_heurePriseCommande, LocalTime COM_heureRemiseCommandeLivreur, LocalTime COM_heureValidationPaiement, LocalTime COM_heureFinDeLivraison) {
        this.COM_REFERENCE = COM_REFERENCE;
        this.TAU_ID = TAU_ID;
        this.MODER_ID = MODER_ID;
        this.CAR_ID = CAR_ID;
        this.LIV_ID = LIV_ID;
        this.MODP_ID = MODP_ID;
        this.SIT_ID = SIT_ID;
        this.COM_date = COM_date;
        this.COM_dateHeureValide = COM_dateHeureValide;
        this.COM_heureDebutPrepa = COM_heureDebutPrepa;
        this.COM_heureFinPrepa = COM_heureFinPrepa;
        this.COM_heurePriseCommande = COM_heurePriseCommande;
        this.COM_heureRemiseCommandeLivreur = COM_heureRemiseCommandeLivreur;
        this.COM_heureValidationPaiement = COM_heureValidationPaiement;
        this.COM_heureFinDeLivraison = COM_heureFinDeLivraison;
    }

    public Integer getCOM_REFERENCE() {
        return COM_REFERENCE;
    }

    public void setCOM_REFERENCE(Integer COM_REFERENCE) {
        this.COM_REFERENCE = COM_REFERENCE;
    }

    public Integer getTAU_ID() {
        return TAU_ID;
    }

    public void setTAU_ID(Integer TAU_ID) {
        this.TAU_ID = TAU_ID;
    }

    public Integer getMODER_ID() {
        return MODER_ID;
    }

    public void setMODER_ID(Integer MODER_ID) {
        this.MODER_ID = MODER_ID;
    }

    public Integer getCAR_ID() {
        return CAR_ID;
    }

    public void setCAR_ID(Integer CAR_ID) {
        this.CAR_ID = CAR_ID;
    }

    public Integer getLIV_ID() {
        return LIV_ID;
    }

    public void setLIV_ID(Integer LIV_ID) {
        this.LIV_ID = LIV_ID;
    }

    public Integer getMODP_ID() {
        return MODP_ID;
    }

    public void setMODP_ID(Integer MODP_ID) {
        this.MODP_ID = MODP_ID;
    }

    public Integer getSIT_ID() {
        return SIT_ID;
    }

    public void setSIT_ID(Integer SIT_ID) {
        this.SIT_ID = SIT_ID;
    }

    public LocalDate getCOM_date() {
        return COM_date;
    }

    public void setCOM_date(LocalDate COM_date) {
        this.COM_date = COM_date;
    }

    public LocalDate getCOM_dateHeureValide() {
        return COM_dateHeureValide;
    }

    public void setCOM_dateHeureValide(LocalDate COM_dateHeureValide) {
        this.COM_dateHeureValide = COM_dateHeureValide;
    }

    public LocalTime getCOM_heureDebutPrepa() {
        return COM_heureDebutPrepa;
    }

    public void setCOM_heureDebutPrepa(LocalTime COM_heureDebutPrepa) {
        this.COM_heureDebutPrepa = COM_heureDebutPrepa;
    }

    public LocalTime getCOM_heureFinPrepa() {
        return COM_heureFinPrepa;
    }

    public void setCOM_heureFinPrepa(LocalTime COM_heureFinPrepa) {
        this.COM_heureFinPrepa = COM_heureFinPrepa;
    }

    public LocalTime getCOM_heurePriseCommande() {
        return COM_heurePriseCommande;
    }

    public void setCOM_heurePriseCommande(LocalTime COM_heurePriseCommande) {
        this.COM_heurePriseCommande = COM_heurePriseCommande;
    }

    public LocalTime getCOM_heureRemiseCommandeLivreur() {
        return COM_heureRemiseCommandeLivreur;
    }

    public void setCOM_heureRemiseCommandeLivreur(LocalTime COM_heureRemiseCommandeLivreur) {
        this.COM_heureRemiseCommandeLivreur = COM_heureRemiseCommandeLivreur;
    }

    public LocalTime getCOM_heureValidationPaiement() {
        return COM_heureValidationPaiement;
    }

    public void setCOM_heureValidationPaiement(LocalTime COM_heureValidationPaiement) {
        this.COM_heureValidationPaiement = COM_heureValidationPaiement;
    }

    public LocalTime getCOM_heureFinDeLivraison() {
        return COM_heureFinDeLivraison;
    }

    public void setCOM_heureFinDeLivraison(LocalTime COM_heureFinDeLivraison) {
        this.COM_heureFinDeLivraison = COM_heureFinDeLivraison;
    }
}
