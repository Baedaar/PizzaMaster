package fr.eql.ai113.dao;

import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.Produit;

import java.time.LocalDate;
import java.util.List;

public interface ProduitDao {
    List<Ingredient> ingredientsDansProduit(Produit produit);
    Boolean creerProduit(Produit produit);
    Produit modifierProduit(Produit produit);
    LocalDate retirerProduit(Produit produit);
    List<Produit> listerProduits();
    List<Produit> listerProduitsParType(String intitule);
}
