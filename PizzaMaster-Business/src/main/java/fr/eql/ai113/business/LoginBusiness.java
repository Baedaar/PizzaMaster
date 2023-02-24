package fr.eql.ai113.business;

import fr.eql.ai113.entity.Client;

public interface LoginBusiness {

    Client authentification(String email, String password);
}
