package fr.eql.ai113.business;

import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;

import java.util.List;

public interface ClientBusiness {

    public List<Adresse> avoirListeAdresseDuClient(Client client);

}
