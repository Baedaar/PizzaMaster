package fr.eql.ai113.dao;

import fr.eql.ai113.entity.Commande;

import java.util.List;

public interface CommandeDao {
    public boolean CreerCommande(Commande commande);
    public List<Commande> ListerCommande();
}
