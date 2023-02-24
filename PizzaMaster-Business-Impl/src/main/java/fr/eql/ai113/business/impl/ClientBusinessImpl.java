package fr.eql.ai113.business.impl;

import fr.eql.ai113.business.ClientBusiness;
import fr.eql.ai113.dao.ClientDao;
import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(ClientBusiness.class)
@Stateless
public class ClientBusinessImpl implements ClientBusiness {
    @EJB
    private ClientDao clientDao;


    @Override
    public List<Adresse> avoirListeAdresseDuClient(Client client) {
        return clientDao.adressesPourClient(client) ;
    }
}
