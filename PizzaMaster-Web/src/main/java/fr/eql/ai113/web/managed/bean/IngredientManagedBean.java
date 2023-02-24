package fr.eql.ai113.web.managed.bean;

import fr.eql.ai113.business.IngredientBusiness;
import fr.eql.ai113.entity.Ingredient;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "mbIngredient")
@ViewScoped
public class IngredientManagedBean {
    private Long TYPEI_id;
    private String ING_intitule;
    private Short ING_complementaire;
    @EJB
    private IngredientBusiness ingredientBusiness;
    private List<Ingredient> expressions;
    @PostConstruct
    public void init(){
        String forward;
        expressions = ingredientBusiness.listerIngredients();
        if (expressions.isEmpty()){
            forward = "/index.xhtml?faces-redirect=true";
        }
    }
    public List<Ingredient> getAllIngredients() {
        expressions = ingredientBusiness.listerIngredients();
        System.out.println(expressions);
        return ingredientBusiness.listerIngredients();
    }
    public void creerIng(){
        ingredientBusiness.creerIngredient(
                new Ingredient(
                        TYPEI_id,
                        ING_intitule,
                        ING_complementaire
                )
        );
    }

    public String getING_intitule() {
        return ING_intitule;
    }

    public void setING_intitule(String ING_intitule) {
        this.ING_intitule = ING_intitule;
    }

    public Short getING_complementaire() {
        return ING_complementaire;
    }

    public void setING_complementaire(Short ING_complementaire) {
        this.ING_complementaire = ING_complementaire;
    }

    public List<Ingredient> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Ingredient> expressions) {
        this.expressions = expressions;
    }

    public Long getTYPEI_id() {
        return TYPEI_id;
    }

    public void setTYPEI_id(Long TYPEI_id) {
        this.TYPEI_id = TYPEI_id;
    }
}
