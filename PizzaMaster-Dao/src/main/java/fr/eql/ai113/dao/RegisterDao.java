package fr.eql.ai113.dao;

import fr.eql.ai113.entity.Client;

import java.util.List;

public interface RegisterDao {

    void listGenre (List<String> genres);

     boolean insertClient(Client client);
}
