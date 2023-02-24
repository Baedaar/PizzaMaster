package fr.eql.ai113.business;

import fr.eql.ai113.entity.Commande;

import java.util.List;

public interface CommandeBusiness {
    public boolean CreerCommande(Commande commande);
    public List<Commande> ListerCommande();
}
