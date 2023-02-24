package fr.eql.ai113.web.managed.bean;


import fr.eql.ai113.business.AdresseBusiness;
import fr.eql.ai113.business.LoginBusiness;
import fr.eql.ai113.business.RegisterBusiness;
import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;
import fr.eql.ai113.entity.Lieu;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "mbSpace")
@SessionScoped
public class SpaceManagedBean {

    @EJB
    private AdresseBusiness adresseBusiness;
    @EJB
    private LoginBusiness loginBusiness;
    Client client;
    Adresse adresse;
    List<Lieu> villes;
    List<Lieu> codePostaux;

    /**
     * Faire une methode pour remplir le code postal en fonction du choix de la selection de la ville.
     */


    private long ADD_id;
    private int ADD_numeroRue;
    private String ADD_nomVoie;

    public List<Adresse> allClientAdresses (Client connectedClient) {
        List<Adresse> adresses = adresseBusiness.displayClientAdresse(connectedClient.getCLI_id());
        return adresses;
    }

    public List<Lieu> displayVille() {
        villes = adresseBusiness.displayLieuxVille();
        return villes;
    }

    public List<Lieu> displayCP(){
        codePostaux = adresseBusiness.displayLieuxCP();
        return codePostaux;
    }

    public void enregistrerAdresse() {
        adresseBusiness.creerAdresse(adresse,client);
    }

    public AdresseBusiness getAdresseBusiness() {
        return adresseBusiness;
    }

    public void setAdresseBusiness(AdresseBusiness adresseBusiness) {
        this.adresseBusiness = adresseBusiness;
    }

    public LoginBusiness getLoginBusiness() {
        return loginBusiness;
    }

    public void setLoginBusiness(LoginBusiness loginBusiness) {
        this.loginBusiness = loginBusiness;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getADD_id() {
        return ADD_id;
    }

    public void setADD_id(long ADD_id) {
        this.ADD_id = ADD_id;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
