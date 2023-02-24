package fr.eql.ai113.dao.impl;

import fr.eql.ai113.dao.LigneCommandeDao;
import fr.eql.ai113.dao.ProduitDao;
import fr.eql.ai113.dao.impl.connection.PizzaMasterDataSource;
import fr.eql.ai113.entity.Commande;
import fr.eql.ai113.entity.Constituer;
import fr.eql.ai113.entity.Ingredient;
import fr.eql.ai113.entity.LigneCommande;
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

@Remote(LigneCommandeDao.class)
@Stateless
public class LigneCommandeDaoImpl implements LigneCommandeDao {
    private static final Logger logger = LogManager.getLogger();
    DataSource dataSource = new PizzaMasterDataSource();
    private static final String REQ_AJOUTER_PROD_COM = "INSERT INTO ligne_commande (COM_REFERENCE, PROD_ID, LIGC_QUANTITE) VALUES (?,?,?)";
    private static final String REQ_LISTER_COM_PROD = "SELECT p.PROD_INTITULE, p.PROD_IMAGE FROM ligne_commande lc LEFT JOIN produit p ON p.PROD_ID = lc.PROD_ID LEFT JOIN commande c ON c.COM_REFERENCE = lc.COM_REFERENCE WHERE c.COM_REFERENCE=?";
    public Boolean ajouterProduit(LigneCommande ligneCommande) {
        Boolean estInsere = false;
        // Un try with resources comme ici permet de lancer la méthode .close() de l'objet donné en paramètres
        // (ici "Connection"), même si on entre dans le catch. Ainsi on est 100% sûr qu'il est fermé.
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_AJOUTER_PROD_COM);
            statement.setInt(1, ligneCommande.getCOM_reference());
            statement.setInt(2, ligneCommande.getPROD_ID());
            statement.setInt(2, ligneCommande.getLIGC_quantite());
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
    public List<LigneCommande> afficherLignesCommande(Commande commande) {
        System.out.println("LIGC_id : "+commande.getCOM_REFERENCE());
        List<LigneCommande> listeLigneCommandes = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_LISTER_COM_PROD);
            statement.setLong(1,commande.getCOM_REFERENCE());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                LigneCommande ligneCommande = new LigneCommande(
                        resultSet.getInt("LIGC_ID"),
                        resultSet.getInt("COM_reference"),
                        resultSet.getInt("PROD_ID"),
                        resultSet.getInt("LIGC_quantite")
                );
                listeLigneCommandes.add(ligneCommande);
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }
        return listeLigneCommandes;
    }
}
