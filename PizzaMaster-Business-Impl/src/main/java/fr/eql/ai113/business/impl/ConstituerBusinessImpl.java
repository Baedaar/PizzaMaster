package fr.eql.ai113.business.impl;

import fr.eql.ai113.business.ConstituerBusiness;
import fr.eql.ai113.dao.ConstituerDao;
import fr.eql.ai113.dao.IngredientDao;
import fr.eql.ai113.dao.ProduitDao;
import fr.eql.ai113.entity.Constituer;
import fr.eql.ai113.entity.Ingredient;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(ConstituerBusiness.class)
@Stateless
public class ConstituerBusinessImpl implements ConstituerBusiness {
    @EJB
    private ConstituerDao constituerDao;
    @EJB
    private ProduitDao produitDao;
    @EJB
    private IngredientDao ingredientDao;
    @Override
    public Boolean constituerProduit(Constituer constituer) {
        return constituerDao.constituerProduit(constituer);
    }

    @Override
    public List<Ingredient> listerIngredientsParProduit(Integer produit) {
        return constituerDao.listerIngredientsParProduit(produit);
    }
}
