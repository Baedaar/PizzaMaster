package fr.eql.ai113.dao;

import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;
import fr.eql.ai113.entity.Lieu;

import java.sql.Connection;
import java.util.List;

public interface AdresseDao {

    List<Adresse> displayClientAdresses(long idClient);

    public Adresse donnerAdresseClient(Client client, Adresse newAdresse);

    void creerAdresse (Adresse adresse, Client client);

    List<Lieu> lieuListVille ();

    List<Lieu> lieuListCP();
}
