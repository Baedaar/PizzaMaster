package fr.eql.ai113.web.managed.bean;

import fr.eql.ai113.business.ConstituerBusiness;
import fr.eql.ai113.business.ProduitBusiness;
import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.Produit;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;
import java.util.List;

@ManagedBean(name = "mbConstituer")
@ViewScoped
public class ConstituerManagedBean {
    @EJB
    private ConstituerBusiness constituerBusiness;
    @EJB
    private  ProduitBusiness produitBusiness;

    private List<Ingredient> expressions;
    private Integer selectedExpression ;
    private Produit produit;

    public void init(){
        String forward;
        expressions = constituerBusiness.listerIngredientsParProduit(selectedExpression);
        if (expressions.isEmpty()){
            forward = "/index.xhtml?faces-redirect=true";
        }
    }
    public void buttonClicked(ActionEvent event) {
        UIComponent source = event.getComponent();
        Integer intitule = (Integer) source.getAttributes().get("data-intitule");
        selectedExpression = intitule;
    }
    public List<Ingredient> listerIngredientsParProduit(){
        expressions = constituerBusiness.listerIngredientsParProduit(selectedExpression);
        System.out.println(expressions);
        return constituerBusiness.listerIngredientsParProduit(selectedExpression);
    }

}
