package fr.eql.ai113.dao;

import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.TypeIngredient;

import java.time.LocalDate;
import java.util.List;

public interface IngredientDao {
    Boolean creerIngredient(Ingredient ingredient);
    Ingredient modifierIngredient(Ingredient ingredient);
    LocalDate retirerIngredient(Ingredient ingredient);
    List<Ingredient> listerIngredients();
    List<TypeIngredient> listerTypeIngredients();
    List<Ingredient> listerIngredientsParType(String intitule);

}
