package fr.eql.ai113.business;

import fr.eql.ai113.entity.Lieu;
import fr.eql.ai113.entity.Site;

import java.util.List;

public interface SiteBusiness {


    List<Site> getListOfSites();


    List<Lieu> getListOfLieu();

    boolean insertLieu(Lieu lieu);

    boolean modifyLieu(Lieu lieu);
    boolean deleteLieu(Lieu lieu);



    Site getsiteupdatewithlieu(Site site);

    boolean insertSite(Site site);
    boolean modifySite(Site site);
    void deleteSite(Site site);



}
