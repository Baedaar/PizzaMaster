package fr.eql.ai113.dao;

import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;

import java.util.List;

public interface ClientDao {

    Client authenticate(String email, String password);
    boolean exists(Client client);
    boolean insertClient(Client client);

    List<Adresse> adressesPourClient(Client client);
}
