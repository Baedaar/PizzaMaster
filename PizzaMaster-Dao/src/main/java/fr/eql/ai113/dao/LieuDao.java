package fr.eql.ai113.dao;

import fr.eql.ai113.entity.Lieu;
import fr.eql.ai113.entity.Site;

import java.util.List;

public interface LieuDao {


    /**     SITE
     */
     boolean insertSite(Site site);
     boolean modifySite(Site site);
     void deleteSite(Site site);

    List<Site> findBySiteNom(Site site);

     List<Site> listOfAllSites();

    /**     lieu
     */
    boolean insertLieu(Lieu lieu);
    boolean modifyLieu(Lieu lieu);
    boolean deleteLieu(Lieu lieu);

    /**      METHODES OF DAO
   */







    List<Lieu> listOfAllLieu();


}
