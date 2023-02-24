package fr.eql.ai113.business.impl;



import fr.eql.ai113.business.SiteBusiness;
import fr.eql.ai113.dao.LieuDao;
import fr.eql.ai113.entity.Lieu;
import fr.eql.ai113.entity.Site;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(SiteBusiness.class)
@Stateless
public class SiteBusinessImpl implements SiteBusiness {

    @EJB
    private LieuDao lieuDao;



    @Override
    public boolean insertLieu(Lieu lieu) {
        return lieuDao.insertLieu(lieu);
    }

    @Override
    public boolean modifyLieu(Lieu lieu) {
        return lieuDao.modifyLieu(lieu);
    }

    @Override
    public boolean deleteLieu(Lieu lieu)
    {
        return lieuDao.deleteLieu(lieu);
    }


    @Override
    public List<Lieu> getListOfLieu() {
        return lieuDao.listOfAllLieu();
    }


    @Override
    public Site getsiteupdatewithlieu(Site site) {
        site.getsites().addAll(lieuDao.findBySiteNom(site));
        return site;
    }

    @Override
    public boolean insertSite(Site site){
        return   lieuDao.insertSite(site);
    }



    @Override
    public boolean modifySite(Site site) {
        return lieuDao.modifySite(site);
    }

    @Override
    public void deleteSite(Site site) {
        lieuDao.deleteSite(site);
    }


    @Override
    public List<Site> getListOfSites() {
        return lieuDao.listOfAllSites();
    }


}
