package fr.eql.ai113.business.impl;

import fr.eql.ai113.business.LigneCommandeBusiness;
import fr.eql.ai113.dao.LigneCommandeDao;
import fr.eql.ai113.entity.Commande;
import fr.eql.ai113.entity.LigneCommande;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(LigneCommandeBusiness.class)
@Stateless
public class LigneCommandeBusinessImpl implements LigneCommandeBusiness{
    @EJB
    private LigneCommandeDao ligneCommandeDao;

    public Boolean ajouterProduit(LigneCommande ligneCommande) {
        return ligneCommandeDao.ajouterProduit(ligneCommande);
    }


    public List<LigneCommande> afficherLignesCommande(Commande commande) {
        return ligneCommandeDao.afficherLignesCommande(commande);
    }
}
