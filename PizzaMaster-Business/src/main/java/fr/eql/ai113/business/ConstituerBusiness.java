package fr.eql.ai113.business;

import fr.eql.ai113.entity.Constituer;
import fr.eql.ai113.entity.Ingredient;

import java.util.List;

public interface ConstituerBusiness {
    Boolean constituerProduit(Constituer constituer);
    List<Ingredient> listerIngredientsParProduit(Integer produit);
}
