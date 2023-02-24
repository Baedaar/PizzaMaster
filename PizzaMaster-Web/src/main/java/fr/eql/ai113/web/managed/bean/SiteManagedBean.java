package fr.eql.ai113.web.managed.bean;

import fr.eql.ai113.business.SiteBusiness;

import fr.eql.ai113.entity.Site;

import fr.eql.ai113.entity.enums.Types;
import fr.eql.ai113.web.managed.bean.utils.StringUtils;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ManagedBean(name = "mbSite")
@ViewScoped
public class SiteManagedBean {





    private String selectedExpression = "";





   private long SIT_id;
   private long LIE_id;
   private String types;
   private String SIT_nom;
   private String  SIT_nomRue;
   private String  SIT_nomVoie;
   private String  SIT_telephone;
   private String  LIE_ville;
   private String  LIE_codePostal;
   private List<String> site_Types = new ArrayList<>();



    @EJB
    private SiteBusiness siteBusiness;


    private List<Site> expection;



    @PostConstruct
    public void initi(){
        String forward;
        expection = siteBusiness.getListOfSites();
        if (expection.isEmpty()){
            forward = "/index.xhtml?faces-redirect=true";
        }
        site_Types = Stream.of(Types.values())
                .map(types -> StringUtils.firstLetterCapitalized(types.toString()))
                .collect(Collectors.toList());
    }
    public List<Site> getAllSite() {
        expection = siteBusiness.getListOfSites();
        System.out.println(expection);
        return siteBusiness.getListOfSites();
    }
    public void creerSite(){
        siteBusiness.insertSite(
                new Site(
                        LIE_id,
                        Types.valueOf(types.toUpperCase()),
                        SIT_nom,
                        SIT_nomRue,
                        SIT_nomVoie,
                        SIT_telephone
                )
        );
        initi();
    }

    public void modifierSite(){
        //siteBusiness.modifySite();
    }

    public void deletesite(){
        //siteBusiness.deleteSite();
    }

    /// Setters ///




    public long getSIT_id() {
        return SIT_id;
    }

    public void setSIT_id(long SIT_id) {
        this.SIT_id = SIT_id;
    }

    public long getLIE_id() {
        return LIE_id;
    }

    public void setLIE_id(long LIE_id) {
        this.LIE_id = LIE_id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getSIT_nom() {
        return SIT_nom;
    }

    public void setSIT_nom(String SIT_nom) {
        this.SIT_nom = SIT_nom;
    }

    public String getSIT_nomRue() {
        return SIT_nomRue;
    }

    public void setSIT_nomRue(String SIT_nomRue) {
        this.SIT_nomRue = SIT_nomRue;
    }

    public String getSIT_nomVoie() {
        return SIT_nomVoie;
    }

    public void setSIT_nomVoie(String SIT_nomVoie) {
        this.SIT_nomVoie = SIT_nomVoie;
    }

    public String getSIT_telephone() {
        return SIT_telephone;
    }

    public void setSIT_telephone(String SIT_telephone) {
        this.SIT_telephone = SIT_telephone;
    }

    public List<String> getSite_Types() {
        return site_Types;
    }

    public void setSite_Types(List<String> site_Types) {
        this.site_Types = site_Types;
    }

    public List<Site> getExpection() {
        return expection;
    }

    public void setExpection(List<Site> expection) {
        this.expection = expection;
    }
}


