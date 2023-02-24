package fr.eql.ai113.business.impl;
import fr.eql.ai113.business.AdresseBusiness;
import fr.eql.ai113.dao.AdresseDao;
import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;
import fr.eql.ai113.entity.Lieu;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;


@Remote(AdresseBusiness.class)
@Stateless
public class AdresseBusinessImpl implements AdresseBusiness {

    @EJB
    AdresseDao adresseDao;

    @Override
    public List<Adresse> displayClientAdresse(long idClient) {
        return adresseDao.displayClientAdresses(idClient);
    }

    @Override
    public void creerAdresse(Adresse adresse,Client client) {
        adresseDao.creerAdresse(adresse,client);
    }

    @Override
    public List<Lieu> displayLieuxVille() {
        return adresseDao.lieuListVille();
    }

    @Override
    public List<Lieu> displayLieuxCP() {
        return adresseDao.lieuListCP();
    }
}
