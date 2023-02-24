package fr.eql.ai113.business;

import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;
import fr.eql.ai113.entity.Lieu;

import java.util.List;

public interface AdresseBusiness {

    List<Adresse> displayClientAdresse(long idClient);

    void creerAdresse(Adresse adresse, Client client);

    List<Lieu> displayLieuxVille ();

    List<Lieu> displayLieuxCP();


}
