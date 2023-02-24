package fr.eql.ai113.business.impl;

import fr.eql.ai113.business.ProduitBusiness;
import fr.eql.ai113.dao.ProduitDao;
import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.Produit;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(ProduitBusiness.class)
@Stateless
public class ProduitBusinessImpl implements ProduitBusiness {
    @EJB
    private ProduitDao produitDao;
    @Override
    public Boolean creeProduit(Produit produit) {
        return produitDao.creerProduit(produit);
    }
    public List<Produit> listerProduits(){ return  produitDao.listerProduits(); }

    @Override
    public List<Ingredient> ingredientsDansProduit(Produit produit) {
        return produitDao.ingredientsDansProduit(produit);
    }
}
