package fr.eql.ai113.dao.impl;

import fr.eql.ai113.dao.ConstituerDao;
import fr.eql.ai113.dao.impl.connection.PizzaMasterDataSource;
import fr.eql.ai113.entity.Constituer;
import fr.eql.ai113.entity.Ingredient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Remote(ConstituerDao.class)
@Stateless
public class ConstituerDaoImpl implements ConstituerDao {
    private static final Logger logger = LogManager.getLogger();
    DataSource dataSource = new PizzaMasterDataSource();
    private static final String REQ_INSERT_CONSTIT_PROD = "INSERT INTO constituer (`PROD_ID`, `ING_ID`) VALUES (?, ?)";
    private static final String REQ_LISTER_ING_PROD = "select i.TYPEI_ID, i.ING_INTITULE, i.ING_COMPLEMENTAIRE from constituer co left join produit p on p.PROD_ID = co.PROD_ID left join ingredient i on i.ING_ID = co.ING_ID where p.PROD_ID=?";
    public Boolean constituerProduit(Constituer constituer) {
        Boolean estInsere = false;
        // Un try with resources comme ici permet de lancer la méthode .close() de l'objet donné en paramètres
        // (ici "Connection"), même si on entre dans le catch. Ainsi on est 100% sûr qu'il est fermé.
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_INSERT_CONSTIT_PROD);
            statement.setLong(1, constituer.getPROD_id());
            statement.setLong(2, constituer.getING_id());
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
    public List<Ingredient> listerIngredientsParProduit(Integer PROD_id) {
        System.out.println("PROD_id : "+PROD_id);
        List<Ingredient> listeIngredients = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_LISTER_ING_PROD);
            statement.setLong(1,PROD_id);
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
