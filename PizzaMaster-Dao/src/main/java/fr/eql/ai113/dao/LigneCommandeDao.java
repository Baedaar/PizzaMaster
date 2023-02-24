package fr.eql.ai113.dao;

import fr.eql.ai113.entity.Commande;
import fr.eql.ai113.entity.LigneCommande;

import java.util.List;

public interface LigneCommandeDao {
    Boolean ajouterProduit(LigneCommande ligneCommande);
    List<LigneCommande> afficherLignesCommande(Commande commande);
}
