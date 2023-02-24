package fr.eql.ai113.business;

import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.Produit;

import java.util.List;

public interface ProduitBusiness {
    Boolean creeProduit(Produit produit);
    List<Produit> listerProduits();
    List<Ingredient> ingredientsDansProduit(Produit produit);
}
