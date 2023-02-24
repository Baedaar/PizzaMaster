package fr.eql.ai113.dao.impl;

import fr.eql.ai113.dao.AdresseDao;
import fr.eql.ai113.dao.impl.connection.PizzaMasterDataSource;
import fr.eql.ai113.dao.ClientDao;
import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Remote(ClientDao.class)
@Stateless
public class ClientDaoImpl implements ClientDao {
    @EJB
    private AdresseDao adresse;
    private static final Logger logger = LogManager.getLogger();

    private final DataSource dataSource = new PizzaMasterDataSource();
    private static final String REQ_AUTH ="SELECT * FROM client WHERE CLI_email = ? AND CLI_MotDePasse = ?";
    private static final String REQ_GEN= "SELECT * FROM genre";
//    private static final String REQ_REG = "INSERT INTO client (CLI_email, CLI_motDePasse, CLI_nom, CLI_prenom, CLI_DateNaissance, CLI_telephone) ";

    @Override
    public Client authenticate(String email, String password) {
        Client client = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_AUTH);
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                client = new Client(
                        resultSet.getString("CLI_nom"),
                        resultSet.getString("CLI_prenom"),
                        resultSet.getString("CLI_email"),
                        resultSet.getString("CLI_motDePasse")
                );
            }
        } catch (SQLException e) {
            logger.error("erreur",e);
        }
        return client;
    }

    @Override
    public boolean exists(Client client) {
        return false;
    }

    @Override
    public boolean insertClient(Client client) {
        boolean isRegistered = false;

        return isRegistered;
    }
    public List<Adresse> adressesPourClient(Client client){
        client.setListAdresse(adresse.displayClientAdresses(client.getCLI_id()));
        return client.getListAdresse();
    }




}
