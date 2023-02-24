package fr.eql.ai113.business.impl;

import fr.eql.ai113.business.CommandeBusiness;
import fr.eql.ai113.dao.CommandeDao;
import fr.eql.ai113.entity.Commande;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(CommandeBusiness.class)
@Stateless
public class CommandeBusinessImpl implements CommandeBusiness{
    @EJB
    private CommandeDao commandeDao;
    @Override
    public boolean CreerCommande(Commande commande) {
        return commandeDao.CreerCommande(commande);
    }

    @Override
    public List<Commande> ListerCommande() {
        return commandeDao.ListerCommande();
    }
}
