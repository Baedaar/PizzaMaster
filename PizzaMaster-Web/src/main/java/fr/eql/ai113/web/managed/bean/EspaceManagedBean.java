package fr.eql.ai113.web.managed.bean;


import fr.eql.ai113.business.AdresseBusiness;
import fr.eql.ai113.business.LoginBusiness;
import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;
import fr.eql.ai113.entity.Lieu;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "mbEspace")
@SessionScoped
public class EspaceManagedBean extends LoginManagedBean {

    @EJB
    private AdresseBusiness adresseBusiness;
    @EJB
    private LoginBusiness loginBusiness;
    Client connectedClient;
    Adresse adresse;
    List<Lieu> villes;
    List<Lieu> codePostaux;

    /**
     * Faire une methode pour remplir le code postal en fonction du choix de la selection de la ville.
     */


    private long CLI_id;
    private int ADD_numeroRue;
    private String ADD_nomVoie;
    private String ADD_escalier;
    private short ADD_etage;
    private String ADD_porte;
    private long LIE_id;
    private String LIE_ville;
    private String LIE_codePostal;
    private long ADD_id;

    List<Adresse> adressesList = new ArrayList<>();



    @PostConstruct
    public void init() {
        adresse = new Adresse(getADD_id(),
                getCLI_id(),
                getADD_numeroRue(),
                getADD_nomVoie(),
                getADD_escalier(),
                getADD_etage(),
                getADD_porte(),
                getLIE_id(),
                getLIE_ville(),
                getLIE_codePostal()
        );
    }

    public ListDataModel<Adresse> getListeModel(long id) {
        return new ListDataModel<>(adresseBusiness.displayClientAdresse(CLI_id));
    }




    public List<Adresse> allClientAdresses (long id) {
        adressesList = adresseBusiness.displayClientAdresse(id);
        return adressesList;
    }

    public List<Adresse> getAdressesList() {
        return adressesList;
    }

    public void setAdressesList(List<Adresse> adressesList) {
        this.adressesList = adressesList;
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
        adresseBusiness.creerAdresse(adresse,connectedClient);
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

    public Client getConnectedClient() {
        return connectedClient;
    }

    public void setConnectedClient(Client connectedClient) {
        this.connectedClient = connectedClient;
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

    public List<Lieu> getVilles() {
        return villes;
    }

    public void setVilles(List<Lieu> villes) {
        this.villes = villes;
    }

    public List<Lieu> getCodePostaux() {
        return codePostaux;
    }

    public void setCodePostaux(List<Lieu> codePostaux) {
        this.codePostaux = codePostaux;
    }

    public long getCLI_id() {
        return CLI_id;
    }

    public void setCLI_id(long CLI_id) {
        this.CLI_id = CLI_id;
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

    public long getLIE_id() {
        return LIE_id;
    }

    public void setLIE_id(long LIE_id) {
        this.LIE_id = LIE_id;
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
}
