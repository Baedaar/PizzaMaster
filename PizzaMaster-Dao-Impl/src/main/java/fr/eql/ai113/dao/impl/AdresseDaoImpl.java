package fr.eql.ai113.dao.impl;

import fr.eql.ai113.dao.AdresseDao;
import fr.eql.ai113.dao.impl.connection.PizzaMasterDataSource;
import fr.eql.ai113.entity.Adresse;
import fr.eql.ai113.entity.Client;
import fr.eql.ai113.entity.Lieu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Remote(AdresseDao.class)
@Stateless
public class AdresseDaoImpl implements AdresseDao {

    private final DataSource dataSource = new PizzaMasterDataSource();


    private final static Logger logger = LogManager.getLogger();
    private final static String REQ_SEL_CLI_ADRESSE = "SELECT * FROM liste_adresse JOIN lieu ON liste_adresse.LIE_ID = lieu.LIE_ID WHERE liste_adresse.CLI_ID = ?";
    private final static String REQ_INSERT_ADD = "INSERT INTO liste_adresse (CLI_ID,LISA_NUMERORUE,LISA_NOMVOIE,LIE_ID) VALUES (?,?,?,?);";
    private final static String REQ_INSERT_LIEU = "INSERT INTO lieu (LIE_id, LIE_ville, LIE_codePostal) VALUES (?,?,?)";
    private final static String REQ_DISPLAY_LIEU_VILLE = "SELECT * FROM lieu";
    private final static String REQ_DISPLAY_LIEU_CP = "SELECT * FROM lieu";

    @Override
    public List<Adresse> displayClientAdresses(long idClient) {
        List<Adresse> adresses = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_SEL_CLI_ADRESSE);
            statement.setLong(1, 3);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Adresse adresse = new Adresse(
                        resultSet.getLong("LISA_id"),
                        resultSet.getLong("CLI_id"),
                        resultSet.getInt("LISA_numeroRue"),
                        resultSet.getString("LISA_nomVoie"),
                        resultSet.getString("LISA_escalier"),
                        resultSet.getShort("LISA_etage"),
                        resultSet.getString("LISA_porte"),
                        resultSet.getLong("LIE_id"),
                        resultSet.getString("LIE_ville"),
                        resultSet.getString("LIE_codePostale")

                );
                adresses.add(adresse);
                for (int i = 0; i < adresses.size(); ++i){
                    System.out.println(" TOTO dans DAO IMPL " + adresses.get(i).getADD_nomVoie());

                }
            }
        } catch (SQLException e) {
            logger.error("Erreur recuperation base de données",e);
        }

        return adresses ;
    }

    @Override
    public Adresse donnerAdresseClient(Client client, Adresse newAdresse) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_INSERT_ADD);
            statement.setLong(1, client.getCLI_id());
            statement.setString(2, newAdresse.getLIE_ville());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Adresse adresse = new Adresse (
                        resultSet.getLong("LISA_id"),
                        resultSet.getLong("CLI-id"),
                        resultSet.getInt("LISA_numeroRue"),
                        resultSet.getString("LISA_nomVoie"),
                        resultSet.getString("LISA_escalier"),
                        resultSet.getShort("LISA_etage"),
                        resultSet.getString("LISA_porte"),
                        resultSet.getLong("LIE_id"),
                        resultSet.getString("LIE_ville"),
                        resultSet.getString("LIE_codePostale")
                );
            }
        } catch (SQLException e) {
            logger.error("Erreur recuperation base de données", e);
        }
        return newAdresse;
    }

    @Override
    public void creerAdresse(Adresse adresse, Client client) {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            long id = lieuStatementEx(adresse ,connection);
            if (id > 0) {
                adresseStatementExecution(adresse, client, connection);
            } else {
                connection.rollback();
            }
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'insertion de " + adresse +
                    " en base de données.", e);
        }

    }

    @Override
    public List<Lieu> lieuListVille() {
        List<Lieu> lieux = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_DISPLAY_LIEU_VILLE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lieux.add(
                        new Lieu(
                                resultSet.getLong("LIE_id"),
                                resultSet.getString("LIE_ville"),
                                resultSet.getString("LIE_codePostale")


                        ));
            }
        } catch (SQLException e) {
            logger.error("Erreur recuperation base de données", e);
        }


        return lieux ;
    }

    @Override
    public List<Lieu> lieuListCP() {
        List<Lieu> lieux = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_DISPLAY_LIEU_CP);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lieux.add(
                        new Lieu(
                                resultSet.getLong("LIE_id"),
                                resultSet.getString("LIE_ville"),
                                resultSet.getString("LIE_codePostale")


                        ));
            }
        } catch (SQLException e) {
            logger.error("Erreur recuperation base de données", e);
        }


        return lieux ;
    }

    public long lieuStatementEx(Adresse adresse, Connection connection) throws SQLException {
        long id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_INSERT_LIEU, Statement.RETURN_GENERATED_KEYS);
        statement.setLong(1, adresse.getLIE_id());
        statement.setString(2, adresse.getLIE_ville());
        statement.setString(3, adresse.getLIE_codePostal());
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                    adresse.setLIE_id(id);
                }
            } catch (SQLException e) {
                connection.rollback();
                logger.error("Une erreur s'est produite lors de la récupération de l'id de l'animal inséré.", e);
            }
        }
        return id;
    }
    private void adresseStatementExecution(Adresse adresse,Client client, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(REQ_INSERT_ADD, Statement.RETURN_GENERATED_KEYS);
        statement.setLong(1,client.getCLI_id());
        statement.setInt(2, adresse.getADD_numeroRue());
        statement.setString(3,adresse.getADD_nomVoie());
        statement.setLong(4,adresse.getLIE_id());
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    adresse.setADD_id(id);
                }
            } catch (SQLException e) {
                connection.rollback();
                logger.error("Une erreur s'est produite lors de la récupération de l'id du chat inséré.", e);
            }
        }
    }

}
