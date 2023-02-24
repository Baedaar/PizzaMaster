package fr.eql.ai113.dao.impl;

import fr.eql.ai113.dao.impl.connection.PizzaMasterDataSource;
import fr.eql.ai113.dao.RegisterDao;
import fr.eql.ai113.entity.Client;
import fr.eql.ai113.entity.enums.Genre;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Remote(RegisterDao.class)
@Stateless
public class RegisterDaoImpl implements RegisterDao {

    private static final Logger logger = LogManager.getLogger();

    private static final String REQ_GEN= "SELECT * FROM genre";
    private static final String REQ_INSERT_CLIENT= "INSERT INTO client (`GEN_ID`, `CLI_EMAIL`, `CLI_MOTDEPASSE`, `CLI_NOM`, `CLI_DATENAISSANCE`, `CLI_PRENOM`) VALUES (?, ?, ?, ?, ?, ?);";

    private final DataSource dataSource = new PizzaMasterDataSource();


    @Override
    public void listGenre(List<String> genres) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_GEN);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                genres.add(resultSet.getString("GEN_id"));
            }
        } catch (SQLException e) {
            logger.error("erreur genre",e);
        }


    }

    @Override
    public boolean insertClient(Client newClient) {
        boolean isInserted = false;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_INSERT_CLIENT);
            statement.setLong(1, newClient.getGEN_id());
            statement.setString(2,newClient.getCLI_email());
            statement.setString(3,newClient.getCLI_MotDePasse());
            statement.setString(4,newClient.getCLI_nom());
            statement.setDate(5,  Date.valueOf(newClient.getCLI_dateNaissance()));
            statement.setString(6,newClient.getCLI_prenom());
            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                isInserted = true;
            }
        } catch (SQLException e) {
            logger.error("erreur genre",e);
        }


        return isInserted;
    }

}
