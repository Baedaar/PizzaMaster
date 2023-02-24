package fr.eql.ai113.business.impl;

import fr.eql.ai113.business.LoginBusiness;
import fr.eql.ai113.dao.ClientDao;
import fr.eql.ai113.entity.Client;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(LoginBusiness.class)
@Stateless
public class LoginBusinessImpl implements LoginBusiness {

    @EJB
    private ClientDao clientDao;

    @Override
    public Client authentification(String email, String password) {
        return clientDao.authenticate(email,password);
    }

}
