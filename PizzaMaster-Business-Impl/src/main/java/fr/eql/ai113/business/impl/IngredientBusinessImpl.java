package fr.eql.ai113.business.impl;

import fr.eql.ai113.business.IngredientBusiness;
import fr.eql.ai113.dao.IngredientDao;
import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.TypeIngredient;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(IngredientBusiness.class)
@Stateless
public class IngredientBusinessImpl implements IngredientBusiness{
    @EJB
    private IngredientDao ingredientDao;


    @Override
    public Boolean creerIngredient(Ingredient ingredient) {
        return ingredientDao.creerIngredient(ingredient);
    }

    @Override
    public List<Ingredient> listerIngredients() {
        return ingredientDao.listerIngredients();
    }

    @Override
    public List<TypeIngredient> listerTypeIngredients() {
        return ingredientDao.listerTypeIngredients();
    }
}
