package fr.eql.ai113.business.impl;

import fr.eql.ai113.business.RegisterBusiness;
import fr.eql.ai113.dao.RegisterDao;
import fr.eql.ai113.entity.Client;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(RegisterBusiness.class)
@Stateless
public class RegisterBusinessImpl implements RegisterBusiness {

    @EJB
    private RegisterDao registerDao;
    @Override
    public void insertClient(Client client) {
        registerDao.insertClient(client);
    }

    @Override
    public void displayGenreList(List<String> genres) {
        registerDao.listGenre(genres);
    }
}
