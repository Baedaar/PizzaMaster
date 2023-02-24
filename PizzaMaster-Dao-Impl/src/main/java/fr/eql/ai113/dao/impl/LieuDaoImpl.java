package fr.eql.ai113.dao.impl;


import fr.eql.ai113.dao.impl.connection.PizzaMasterDataSource;
import fr.eql.ai113.entity.Lieu;
import fr.eql.ai113.entity.Site;
import fr.eql.ai113.dao.LieuDao;
import fr.eql.ai113.entity.enums.Types;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Remote(LieuDao.class)
@Stateless
public class LieuDaoImpl implements LieuDao {

    private Logger logger = LogManager.getLogger();

    /***
     *
     *  site query for delete, insert, modify
     */
    private static final String REQ_INSERT_SITE = "insert into site(LIE_ID,TYPES_ID,SIT_NOM,SIT_NOMRUE,SIT_NOMVOIE,SIT_TELEPHONE)values(?,?,?,?,?,?);";
    private static final String REQ_MODIFY_SITE = "UPDATE site SET  LIE_ID = ?, TYPES_ID= ? ,SIT_NOM= ?, SIT_NOMRUE = ? , SIT_NOMVOIE= ? , SIT_TELEPHONE=? WHERE  SIT_ID= ? ";
    private static final String REQ_DELETE_SITE = "DELETE  FROM site WHERE site.SIT_NOM = ? ;";
    private static final String REQ_ALL_SITE = "SELECT * FROM site;";

    private static final String REQ_FIND_BY_SITE = "SELECT * FROM site where site.SIT_NOM = ? ";



    /***
     *  lieu query for delete, modify, insert
     */


    private  static final String REQ_INSERT_LIEU = "insert into lieu(LIE_ID,LIE_VILLE, LIE_CODEPOSTALE) values(?,?,?) ;";
    private static final String REQ_MODIFY_LIEU = "UPDATE lieu  SET LIE_VILLE = ?, LIE_CODEPOSTALE = ? WHERE LIE_ID = ? ; ";
    private static final String REQ_DELETE_LIEU = " DELETE FROM lieu where lieu.LIE_VILLE = ? ;";

    private static final String REQ_ALL_LIEU = "SELECT * FROM lieu ;";

    private final DataSource dataSource = new PizzaMasterDataSource();


    /**
     *
     * @param site      SITE
     * @return
     */


    @Override
    public boolean insertSite(Site site) {
        boolean isInserted = false;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_INSERT_SITE);
            statement.setLong(1, site.getLIE_id());
            statement.setLong(2, site.getTypes().ordinal() + 1);
            statement.setString(3, site.getSIT_nom());
            statement.setString(4, site.getSIT_nomRue());
            statement.setString(5, site.getSIT_nomVoie());
            statement.setString(6, site.getSIT_telephone());


            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                isInserted = true;
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'insertion du propriétaire " +
                    "en base de données.", e);
        }

        return  isInserted;
    }
    //// Modify the site
    @Override
    public boolean modifySite(Site site) {
        boolean isModified = false;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_MODIFY_SITE);
            statement.setLong(1, site.getLIE_id());
            statement.setLong(2, site.getTypes().ordinal() + 1);
            statement.setString(3, site.getSIT_nom());
            statement.setString(4, site.getSIT_nomRue());
            statement.setString(5, site.getSIT_nomVoie());
            statement.setString(6, site.getSIT_telephone());
            statement.setLong(7, site.getSIT_id());

            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                isModified = true;

            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'insertion du propriétaire " +
                    "en base de données.", e);
        }
        return isModified;
    }
    //// Delete the site
    @Override
    public void deleteSite(Site site) {

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement Statement= connection.prepareStatement(REQ_DELETE_SITE);
            Statement.setString(1, site.getSIT_nom());
            Statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'insertion du propriétaire " +
                    "en base de données.", e);
        }
    }



    @Override
    public List<Site> listOfAllSites() {
        List<Site> listeSite = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_ALL_SITE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Site site  = new Site(

                        resultSet.getLong("SIT_id"),
                        resultSet.getLong("LIE_id"),
                        resultSet.getString("SIT_nom"),
                        resultSet.getString("SIT_nomRue"),
                        resultSet.getString("SIT_nomVoie"),
                        resultSet.getString("SIT_telephone")


                );
                if ( resultSet.getInt("TYPES_ID") == 1){
                    site.setTypes(Types.COORDINATION);
                } else {
                    site.setTypes(Types.PRODUCTION);
                }

                listeSite.add(site);
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }

        return listeSite;
    }


    /**
     *
     * @param lieu      LIEU
     * @return
     */

    //// Insert the lieu
    @Override
    public boolean insertLieu(Lieu lieu) {
        boolean isInserted = false;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_INSERT_LIEU);
            statement.setLong(1, lieu.getLIE_id());
            statement.setString(2, lieu.getLIE_ville());
            statement.setString(3, lieu.getLIE_codePostal());


            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                isInserted = true;
            }

        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'insertion du propriétaire " +
                    "en base de données.", e);
        }
        return isInserted;
    }

    //// modify the lieu
    @Override
    public boolean modifyLieu(Lieu lieu) {
        boolean isModified = false;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(REQ_MODIFY_LIEU);
            statement.setString(1, lieu.getLIE_ville());
            statement.setString(2, lieu.getLIE_codePostal());
            statement.setLong(3, lieu.getLIE_id());

            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                isModified = true;
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'insertion du propriétaire " +
                    "en base de données.", e);
        }
        return isModified;
    }

    /*  delete the lieu*/

    @Override
    public boolean deleteLieu(Lieu lieu) {
        boolean isDeleted = false;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_DELETE_LIEU);
            statement.setString(1,lieu.getLIE_ville());

            int returnedValue = statement.executeUpdate();
            if (returnedValue > 0) {
                isDeleted = true;
            }

        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }

        return isDeleted ;
    }

    @Override
    public List<Site> findBySiteNom(Site site) {
        return null;
    }


    @Override
    public List<Lieu> listOfAllLieu() {
        List<Lieu> listeLieu = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(REQ_ALL_LIEU);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Lieu lieu  = new Lieu(
                        resultSet.getLong("LIE_ID"),
                        resultSet.getString("LIE_VILLE"),
                        resultSet.getString("LIE_CODEPOSTALE")
                );
                listeLieu.add(lieu);
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des propriétaires en base de données.", e);
        }

        return listeLieu;
    }






//    @Override
//    public List<Site> findBySiteNom(Site site) {
//        List<Site> sites = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection()) {
//            PreparedStatement statement = connection.prepareStatement(REQ_FIND_BY_SITE);
//            statement.setString(1, site.getSIT_nom());
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                sites.add(new Site(
//                        resultSet.getLong("LIE_id"),
//
//
//                        resultSet.getString("SIT_nom"),
//                        resultSet.getString("SIT_NUMERORUE"),
//                        resultSet.getString("SIT_NOMVOIE"),
//                        resultSet.getString("SIT_TELEPHONE"),
//                        resultSet.getString("type")
//                ));
//            }
//        } catch (SQLException e) {
//            logger.error("Une erreur s'est produite lors de la consultation des chats dans le base de données.", e);
//        }
//        return sites;
//    }






}
