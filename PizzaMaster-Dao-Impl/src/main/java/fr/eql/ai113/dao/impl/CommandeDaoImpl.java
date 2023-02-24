package fr.eql.ai113.dao.impl;

import fr.eql.ai113.dao.CommandeDao;
import fr.eql.ai113.dao.impl.connection.PizzaMasterDataSource;
import fr.eql.ai113.entity.Commande;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Remote(CommandeDao.class)
@Stateless
public class CommandeDaoImpl implements CommandeDao{
    @EJB
    private CommandeDao commandeDao;
    private static final Logger logger = LogManager.getLogger();
    DataSource dataSource = new PizzaMasterDataSource();
    private static final String REQ_INSERT_COMM = "INSERT INTO commande (TAU_ID,\n" +
            "                      MODER_ID,\n" +
            "                      CAR_ID,\n" +
            "                      LIV_ID,\n" +
            "                      MODP_ID,\n" +
            "                      SIT_ID,\n" +
            "                      COM_DATE,\n" +
            "                      COM_DATEHEUREVALIDE,\n" +
            "                      COM_HEUREDEBUTPREPA,\n" +
            "                      COM_HEUREFINPREPA,\n" +
            "                      COM_HEUREPRISECOMMANDE,\n" +
            "                      COM_HEUREREMISECOMMANDELIVREUR,\n" +
            "                      COM_HEUREVALIDATIONPAIEMENT,\n" +
            "                      COM_HEUREFINDELIVRAISON) VALUES\n" +
            "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String REQ_SELECT_COMM = "SELECT * FROM commande";
    @Override
    public boolean CreerCommande(Commande commande) {
        Boolean estInsere = false;
        // Un try with resources comme ici permet de lancer la méthode .close() de l'objet donné en paramètres
        // (ici "Connection"), même si on entre dans le catch. Ainsi on est 100% sûr qu'il est fermé.
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_INSERT_COMM);
            statement.setInt(1, commande.getTAU_ID());
            statement.setInt(2, commande.getMODER_ID());
            statement.setInt(3, commande.getCAR_ID());
            statement.setInt(4, commande.getLIV_ID());
            statement.setInt(5, commande.getMODP_ID());
            statement.setInt(6, commande.getSIT_ID());
            statement.setDate(7, Date.valueOf(commande.getCOM_date()));
            statement.setDate(8, Date.valueOf(commande.getCOM_dateHeureValide()));
            statement.setTime(9, Time.valueOf(commande.getCOM_heureDebutPrepa()));
            statement.setTime(10, Time.valueOf(commande.getCOM_heureFinPrepa()));
            statement.setTime(11, Time.valueOf(commande.getCOM_heurePriseCommande()));
            statement.setTime(12, Time.valueOf(commande.getCOM_heureRemiseCommandeLivreur()));
            statement.setTime(13, Time.valueOf(commande.getCOM_heureValidationPaiement()));
            statement.setTime(14, Time.valueOf(commande.getCOM_heureFinDeLivraison()));

            // executeUpdate() renvoie 0 si la requête se passe mal, sinon, renvoie le nombre de colonnes
            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                estInsere = true;
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation du propriétaire en base de données.", e);
        }
        return estInsere;
    }

    @Override
    public List<Commande> ListerCommande() {
        List<Commande> listeCommandes = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_SELECT_COMM);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Commande commande = new Commande(
                        resultSet.getInt("COM_REFERENCE"),
                        resultSet.getInt("TAU_ID"),
                        resultSet.getInt("MODER_ID"),
                        resultSet.getInt("CAR_ID"),
                        resultSet.getInt("LIV_ID"),
                        resultSet.getInt("MODP_ID"),
                        resultSet.getInt("SIT_ID"),
                        resultSet.getDate("COM_date").toLocalDate(),
                        resultSet.getDate("COM_dateHeureValide").toLocalDate(),
                        resultSet.getTime("COM_heureDebutPrepa").toLocalTime(),
                        resultSet.getTime("COM_heureFinPrepa").toLocalTime(),
                        resultSet.getTime("COM_heureRepriseCommande").toLocalTime(),
                        resultSet.getTime("COM_heureRemiseCommandeLivreur").toLocalTime(),
                        resultSet.getTime("COM_heureValidationPaiement").toLocalTime(),
                        resultSet.getTime("COM_heureFinDeLivraison").toLocalTime()
                );
                listeCommandes.add(commande);
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }

        return listeCommandes;
    }
}
