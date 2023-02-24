package fr.eql.ai113.dao;

import fr.eql.ai113.entity.Constituer;
import fr.eql.ai113.entity.Ingredient;

import java.util.List;

public interface ConstituerDao {
    Boolean constituerProduit(Constituer constituer);
    List<Ingredient> listerIngredientsParProduit(Integer PROD_id);
}
