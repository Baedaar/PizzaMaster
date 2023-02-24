package fr.eql.ai113.entity;

import fr.eql.ai113.entity.enums.Genre;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Client implements Serializable {
    private long CLI_id;
    private String CLI_email;
    private String CLI_nom;
    private String CLI_MotDePasse;
    private String CLI_prenom;
    private String CLI_telephone;
    private LocalDate CLI_dateNaissance;
    private LocalDate CLI_dateInscription;
    private LocalDate CLI_validationCompte;
    private Genre GEN;
    private long GEN_id;
    private List<Adresse> listAdresse;

    public long getGEN_id() {
        return GEN_id;
    }

    public void setGEN_id(long GEN_id) {
        this.GEN_id = GEN_id;
    }

    public Client(long CLI_id) {
        this.CLI_id = CLI_id;
    }

    public Client(String CLI_email, String CLI_MotDePasse) {
        this.CLI_email = CLI_email;
        this.CLI_MotDePasse = CLI_MotDePasse;
    }

    public Client(long GEN_id,String CLI_email,String CLI_MotDePasse, String CLI_nom, LocalDate CLI_dateNaissance
    , String CLI_prenom) {
        this.GEN_id = GEN_id;
        this.CLI_email = CLI_email;
        this.CLI_MotDePasse = CLI_MotDePasse;
        this.CLI_nom = CLI_nom;
        this.CLI_dateNaissance = CLI_dateNaissance;
        this.CLI_prenom = CLI_prenom;
    }

    public Client(String CLI_email, String CLI_nom,
                  String CLI_MotDePasse, String CLI_prenom,
                  String CLI_telephone, LocalDate CLI_dateNaissance,
                  LocalDate CLI_dateInscription, LocalDate CLI_validationCompte,
                  Genre GEN, List<Adresse> listAdresse) {
        this.CLI_email = CLI_email;
        this.CLI_nom = CLI_nom;
        this.CLI_MotDePasse = CLI_MotDePasse;
        this.CLI_prenom = CLI_prenom;
        this.CLI_telephone = CLI_telephone;
        this.CLI_dateNaissance = CLI_dateNaissance;
        this.CLI_dateInscription = CLI_dateInscription;
        this.CLI_validationCompte = CLI_validationCompte;
        this.GEN = GEN;
        this.listAdresse = listAdresse;
    }

    public Client(String CLI_email, String CLI_nom, String CLI_MotDePasse,
                  String CLI_prenom, String CLI_telephone,
                  LocalDate CLI_dateNaissance, LocalDate CLI_dateInscription, LocalDate CLI_validationCompte) {
        this.CLI_email = CLI_email;
        this.CLI_nom = CLI_nom;
        this.CLI_MotDePasse = CLI_MotDePasse;
        this.CLI_prenom = CLI_prenom;
        this.CLI_telephone = CLI_telephone;
        this.CLI_dateNaissance = CLI_dateNaissance;
        this.CLI_dateInscription = CLI_dateInscription;
        this.CLI_validationCompte = CLI_validationCompte;
    }

    public Client(String CLI_nom, String CLI_prenom, String CLI_email, String CLI_MotDePasse) {
        this.CLI_nom = CLI_nom;
        this.CLI_prenom = CLI_prenom;
        this.CLI_email = CLI_email;
        this.CLI_MotDePasse = CLI_MotDePasse;
    }

    public Client(String CLI_email, String CLI_nom, String CLI_MotDePasse, String CLI_prenom, Genre GEN, LocalDate CLI_dateNaissance) {
        this.CLI_email = CLI_email;
        this.CLI_nom = CLI_nom;
        this.CLI_MotDePasse = CLI_MotDePasse;
        this.CLI_prenom = CLI_prenom;
        this.GEN = GEN;
        this.CLI_dateNaissance = CLI_dateNaissance;
    }
    public Client(String CLI_email, String CLI_nom, String CLI_MotDePasse, String CLI_prenom, long GEN_id, LocalDate CLI_dateNaissance) {
        this.CLI_email = CLI_email;
        this.CLI_nom = CLI_nom;
        this.CLI_MotDePasse = CLI_MotDePasse;
        this.CLI_prenom = CLI_prenom;
        this.GEN_id = GEN_id;
        this.CLI_dateNaissance = CLI_dateNaissance;
    }



    public String getCLI_email() {
        return CLI_email;
    }

    public Genre getGEN() {
        return GEN;
    }

    public void setGEN(Genre GEN) {
        this.GEN = GEN;
    }

    public void setCLI_email(String CLI_email) {
        this.CLI_email = CLI_email;
    }

    public String getCLI_nom() {
        return CLI_nom;
    }

    public void setCLI_nom(String CLI_nom) {
        this.CLI_nom = CLI_nom;
    }

    public String getCLI_MotDePasse() {
        return CLI_MotDePasse;
    }

    public void setCLI_MotDePasse(String CLI_MotDePasse) {
        this.CLI_MotDePasse = CLI_MotDePasse;
    }

    public String getCLI_prenom() {
        return CLI_prenom;
    }

    public void setCLI_prenom(String CLI_prenom) {
        this.CLI_prenom = CLI_prenom;
    }

    public String getCLI_telephone() {
        return CLI_telephone;
    }

    public void setCLI_telephone(String CLI_telephone) {
        this.CLI_telephone = CLI_telephone;
    }

    public LocalDate getCLI_dateNaissance() {
        return CLI_dateNaissance;
    }

    public void setCLI_dateNaissance(LocalDate CLI_dateNaissance) {
        this.CLI_dateNaissance = CLI_dateNaissance;
    }

    public LocalDate getCLI_dateInscription() {
        return CLI_dateInscription;
    }

    public void setCLI_dateInscription(LocalDate CLI_dateInscription) {
        this.CLI_dateInscription = CLI_dateInscription;
    }

    public LocalDate getCLI_validationCompte() {
        return CLI_validationCompte;
    }

    public void setCLI_validationCompte(LocalDate CLI_validationCompte) {
        this.CLI_validationCompte = CLI_validationCompte;
    }


    public List<Adresse> getListAdresse() {
        return listAdresse;
    }

    public void setListAdresse(List<Adresse> listAdresse) {
        this.listAdresse = listAdresse;
    }

    public long getCLI_id() {
        return CLI_id;
    }

    public void setCLI_id(long CLI_id) {
        this.CLI_id = CLI_id;
    }
}
