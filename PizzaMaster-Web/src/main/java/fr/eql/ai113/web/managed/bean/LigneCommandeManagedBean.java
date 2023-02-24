package fr.eql.ai113.web.managed.bean;

import fr.eql.ai113.business.LigneCommandeBusiness;
import fr.eql.ai113.entity.Commande;
import fr.eql.ai113.entity.LigneCommande;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "mbLigneCommande")
@SessionScoped
public class LigneCommandeManagedBean {
    List<LigneCommande> ligneCommandes;
    Commande commande;
    @EJB
    private LigneCommandeBusiness ligneCommandeBusiness;
    public void init(){
        ligneCommandes = ligneCommandeBusiness.afficherLignesCommande(commande);
    }
    public void ajouterProduit(LigneCommande ligneCommande){

        ligneCommandeBusiness.ajouterProduit(ligneCommande);
    }
}
