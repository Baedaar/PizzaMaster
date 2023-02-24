package fr.eql.ai113.dao.impl;

import fr.eql.ai113.dao.ConstituerDao;
import fr.eql.ai113.dao.ProduitDao;
import fr.eql.ai113.dao.impl.connection.PizzaMasterDataSource;
import fr.eql.ai113.entity.Constituer;
import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.Produit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Remote(ProduitDao.class)
@Stateless
public class ProduitDaoImpl implements ProduitDao {
    @EJB
    private ConstituerDao constituer;
    private static final Logger logger = LogManager.getLogger();
    DataSource dataSource = new PizzaMasterDataSource();
    private static final String REQ_INSERT_PROD = "INSERT INTO produit (TYPEP_ID, TYPEC_ID, PROD_INTITULE, PROD_IMAGE, PROD_TEMPSPREPARATION, PROD_DATEAJOUT,PROD_VOLUME) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String REQ_MODIF_PROD = "UPDATE produit t SET t.TYPEP_ID = ?, TYPEC_ID = ?, t.PROD_INTITULE = ?,t.PROD_IMAGE = ?, t.PROD_TEMPSPREPARATION = ?, t.PROD_DATEAJOUT = ?,t.PROD_VOLUME = ? WHERE t.PROD_ID = ?";
    private static final String REQ_RETIRER_PROD = "UPDATE produit t SET t.PROD_DATERETRAIT = ? WHERE t.PROD_ID = ?";
    private static final String REQ_LISTER_PROD = "SELECT * FROM produit";
    private static final String REQ_LISTER_PROD_TYPE = "SELECT * FROM produit i, type_produit t where i.TYPEP_ID=(SELECT TYPEP_ID FROM type_produit WHERE TYPEP_INTITULE='Pizza')";
    @Override
    public Boolean creerProduit(Produit produit) {
        Boolean estInsere = false;
        // Un try with resources comme ici permet de lancer la méthode .close() de l'objet donné en paramètres
        // (ici "Connection"), même si on entre dans le catch. Ainsi on est 100% sûr qu'il est fermé.
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_INSERT_PROD);
            statement.setLong(1, produit.getTYPEP_ID());
            statement.setLong(2, produit.getTYPEC_ID());
            statement.setString(3, produit.getPROD_intitule());
            statement.setString(4, produit.getPROD_image());
            statement.setFloat(5, produit.getPROD_tempsPreparation());
            statement.setDate(6, Date.valueOf(produit.getPROD_dateAjout()) );
            statement.setFloat(7, produit.getPROD_volume());

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
    public Produit modifierProduit(Produit produit) {
        Boolean estMdofifie = false;
        // Un try with resources comme ici permet de lancer la méthode .close() de l'objet donné en paramètres
        // (ici "Connection"), même si on entre dans le catch. Ainsi on est 100% sûr qu'il est fermé.
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_MODIF_PROD);
            statement.setLong(1, produit.getTYPEP_ID());
            statement.setLong(2, produit.getTYPEC_ID());
            statement.setString(3, produit.getPROD_intitule());
            statement.setString(4, produit.getPROD_image());
            statement.setFloat(5, produit.getPROD_tempsPreparation());
            statement.setDate(6, Date.valueOf(produit.getPROD_dateAjout()));
            statement.setFloat(7, produit.getPROD_volume());
            statement.setLong(8, produit.getPROD_id());
            // executeUpdate() renvoie 0 si la requête se passe mal, sinon, renvoie le nombre de colonnes
            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                estMdofifie = true;
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation du propriétaire en base de données.", e);
        }
        return produit;
    }

    @Override
    public LocalDate retirerProduit(Produit produit) {
        Boolean estSupprime = false;
        LocalDate maintenant = LocalDate.now();
        // Un try with resources comme ici permet de lancer la méthode .close() de l'objet donné en paramètres
        // (ici "Connection"), même si on entre dans le catch. Ainsi on est 100% sûr qu'il est fermé.
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_RETIRER_PROD);
            statement.setDate(1, Date.valueOf(produit.getPROD_dateRetrait()));
            statement.setLong(2, produit.getPROD_id());
            // executeUpdate() renvoie 0 si la requête se passe mal, sinon, renvoie le nombre de colonnes
            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                estSupprime = true;
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation du propriétaire en base de données.", e);
        }
        return maintenant;
    }

    @Override
    public List<Produit> listerProduits() {
        List<Produit> listeProduits = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_LISTER_PROD);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Produit produit = new Produit(
                        resultSet.getInt("PROD_ID"),
                        resultSet.getLong("TYPEP_ID"),
                        resultSet.getLong("TYPEC_ID"),
                        resultSet.getString("PROD_intitule"),
                        resultSet.getString("PROD_image"),
                        resultSet.getFloat("PROD_tempsPreparation"),
                        resultSet.getDate("PROD_dateAjout").toLocalDate(),
                        resultSet.getFloat("PROD_volume")
                );
                listeProduits.add(produit);
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }

        return listeProduits;
    }

    @Override
    public List<Produit> listerProduitsParType(String intitule) {
        List<Produit> listeProduits = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_LISTER_PROD_TYPE);
            statement.setString(1,intitule);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Produit produit = new Produit(
                        resultSet.getInt("PROD_ID"),
                        resultSet.getLong("TYPEP_ID"),
                        resultSet.getLong("TYPEC_ID"),
                        resultSet.getString("PROD_intitule"),
                        resultSet.getString("PROD_image"),
                        resultSet.getFloat("PROD_tempsPreparation"),
                        resultSet.getDate("PROD_dateAjout").toLocalDate(),
                        resultSet.getFloat("PROD_volume")
                );
                listeProduits.add(produit);
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }

        return listeProduits;
    }
    public List<Ingredient> ingredientsDansProduit(Produit produit){
        System.out.println("Produit in DAO: "+produit);
        produit.setListeIngredients(constituer.listerIngredientsParProduit(produit.getPROD_id()));
        return produit.getListeIngredients();
    }
}
