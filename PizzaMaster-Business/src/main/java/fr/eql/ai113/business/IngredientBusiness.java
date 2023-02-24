package fr.eql.ai113.business;

import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.TypeIngredient;

import java.util.List;

public interface IngredientBusiness {
    Boolean creerIngredient(Ingredient ingredient);
    List<Ingredient> listerIngredients();
    List<TypeIngredient> listerTypeIngredients();
}
