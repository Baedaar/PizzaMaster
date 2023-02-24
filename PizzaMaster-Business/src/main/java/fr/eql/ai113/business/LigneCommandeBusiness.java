package fr.eql.ai113.business;

import fr.eql.ai113.entity.Commande;
import fr.eql.ai113.entity.LigneCommande;

import java.util.List;

public interface LigneCommandeBusiness {

    Boolean ajouterProduit(LigneCommande ligneCommande);

    List<LigneCommande> afficherLignesCommande(Commande commande);
}
