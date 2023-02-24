package fr.eql.ai113.dao.impl;

import fr.eql.ai113.dao.IngredientDao;
import fr.eql.ai113.dao.impl.connection.PizzaMasterDataSource;
import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.TypeIngredient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Remote(IngredientDao.class)
@Stateless
public class IngredientDaoImpl implements IngredientDao {
    private static final Logger logger = LogManager.getLogger();
    DataSource dataSource = new PizzaMasterDataSource();
    private static final String REQ_INSERT_ING = "INSERT INTO ingredient (TYPEI_ID, ING_INTITULE, ING_COMPLEMENTAIRE)VALUES (?,?,?)";
    private static final String REQ_MODIF_ING = "UPDATE ingredient t SET t.TYPEI_ID = ?, t.ING_INTITULE = ?, t.ING_COMPLEMENTAIRE = ? WHERE t.ING_ID = ?";
    private static final String REQ_RETIRER_ING = "UPDATE ingredient t SET t.ING_DATERETRAIT = ? WHERE t.ING_ID = ?";
    private static final String REQ_LISTER_ING = "SELECT * FROM ingredient";
    private static final String REQ_LISTER_TYPE = "SELECT * FROM type_ingredient";
    private static final String REQ_LISTER_ING_TYPE = "SELECT * FROM ingredient i, type_ingredient t where i.TYPEI_ID=(SELECT TYPEI_ID FROM type_ingredient WHERE TYPEI_INTITULE=?)";


    @Override
    public Boolean creerIngredient(Ingredient ingredient) {
        Boolean estInsere = false;
        // Un try with resources comme ici permet de lancer la méthode .close() de l'objet donné en paramètres
        // (ici "Connection"), même si on entre dans le catch. Ainsi on est 100% sûr qu'il est fermé.
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_INSERT_ING);
            statement.setLong(1, ingredient.getTYPEI_id());
            statement.setString(2, ingredient.getING_intitule());
            statement.setShort(3, ingredient.getING_complementaire());
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
    public Ingredient modifierIngredient(Ingredient ingredient) {
        Boolean estMdofifie = false;
        // Un try with resources comme ici permet de lancer la méthode .close() de l'objet donné en paramètres
        // (ici "Connection"), même si on entre dans le catch. Ainsi on est 100% sûr qu'il est fermé.
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_MODIF_ING);
            statement.setLong(1, ingredient.getTYPEI_id());
            statement.setString(2, ingredient.getING_intitule());
            statement.setShort(3, ingredient.getING_complementaire());
            statement.setDate(4, (Date) ingredient.getING_dateRetrait());
            // executeUpdate() renvoie 0 si la requête se passe mal, sinon, renvoie le nombre de colonnes
            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                estMdofifie = true;
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation du propriétaire en base de données.", e);
        }
        return ingredient;
    }

    @Override
    public LocalDate retirerIngredient(Ingredient ingredient) {
        Boolean estSupprime = false;
        LocalDate maintenant = LocalDate.now();
        // Un try with resources comme ici permet de lancer la méthode .close() de l'objet donné en paramètres
        // (ici "Connection"), même si on entre dans le catch. Ainsi on est 100% sûr qu'il est fermé.
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_RETIRER_ING);
            statement.setDate(1, (Date) ingredient.getING_dateRetrait());
            statement.setLong(2, ingredient.getING_id());
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
    public List<Ingredient> listerIngredients() {
        List<Ingredient> listeIngredients = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_LISTER_ING);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Ingredient ingredient = new Ingredient(
                        resultSet.getLong("TYPEI_id"),
                        resultSet.getString("ING_intitule"),
                        resultSet.getShort("ING_complementaire")
                );
                listeIngredients.add(ingredient);
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }

        return listeIngredients;
    }
    public List<TypeIngredient> listerTypeIngredients(){
        List<TypeIngredient> listeTypeIngredients = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_LISTER_ING);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                TypeIngredient typeIngredient = new TypeIngredient(
                        resultSet.getString("TYPEI_intitule")
                );
                listeTypeIngredients.add(typeIngredient);
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }
        return listeTypeIngredients;
    }
    public List<Ingredient> listerIngredientsParType(String intitule) {
        List<Ingredient> listeIngredients = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_LISTER_ING_TYPE);
            statement.setString(1,intitule);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Ingredient ingredient = new Ingredient(
                        resultSet.getLong("TYPEI_id"),
                        resultSet.getString("ING_intitule"),
                        resultSet.getShort("ING_complementaire")
                );
                listeIngredients.add(ingredient);
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }

        return listeIngredients;
    }
}
