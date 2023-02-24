package fr.eql.ai113.web.managed.bean;

import fr.eql.ai113.business.ProduitBusiness;
import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.Produit;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.Date;
import java.time.ZoneId;
import java.util.List;


@ManagedBean(name = "mbProduit")
@SessionScoped
public class ProduitManagedBean {
    private boolean modalShown = false;
    private Integer PROD_id;
    private String intitule;
    private String image;
    private Float tempsPreparation;
    int annee;
    int mois;
    int jour;
    private Date date;
    private Float volume;
    private List<Produit> expressions;
    private Produit produitSelectionne;
    private List<Ingredient> ingredients;
    @EJB
    private ProduitBusiness produitBusiness;

    @PostConstruct
    public void init(){
        String forward;
        expressions = produitBusiness.listerProduits();
        produitSelectionne = expressions.get(0);
    }

    public List<Produit> getAllProduct(){
        expressions = produitBusiness.listerProduits();
        System.out.println(expressions);
        return produitBusiness.listerProduits();
    }
    public void creerProd(){
        produitBusiness.creeProduit(
                new Produit(
                        1L,
                        1L,
                        intitule,
                        image,
                        (Float) tempsPreparation,
                        date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        (Float) volume
                )
        );
    }
    public List<Ingredient> alpha(Produit produit){
        System.out.println("Produit in Bean: " + produit);
        return produitBusiness.ingredientsDansProduit(produit);
    }

    public String redirectionIngredient(){
        String forward;
        if (1<10) {
            forward = "/constituer.xhtml?faces-redirect=true";
        } else {
            forward = "/constituer.xhtml?faces-redirect=false";
        }
        return forward;
    }


    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(Float tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public ProduitBusiness getProduitBusiness() {
        return produitBusiness;
    }

    public void setProduitBusiness(ProduitBusiness produitBusiness) {
        this.produitBusiness = produitBusiness;
    }

    public List<Produit> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Produit> expressions) {
        this.expressions = expressions;
    }

    public Integer getPROD_id() {
        return PROD_id;
    }

    public void setPROD_id(Integer PROD_id) {
        this.PROD_id = PROD_id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setProduitSelectionne(Produit produitSelectionne) {
        this.produitSelectionne = produitSelectionne;
    }

    public Produit getProduitSelectionne() {
        return produitSelectionne;
    }
}
