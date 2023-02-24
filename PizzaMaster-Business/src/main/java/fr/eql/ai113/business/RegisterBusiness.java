package fr.eql.ai113.business;

import fr.eql.ai113.entity.Client;
import fr.eql.ai113.entity.enums.Genre;

import java.util.List;

public interface RegisterBusiness {

    void insertClient(Client client);
    void displayGenreList(List<String> genres);

}
