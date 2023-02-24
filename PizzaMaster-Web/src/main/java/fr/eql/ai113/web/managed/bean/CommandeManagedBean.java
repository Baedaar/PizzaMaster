package fr.eql.ai113.web.managed.bean;

import fr.eql.ai113.business.CommandeBusiness;
import fr.eql.ai113.entity.Commande;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "mbCommande")
@SessionScoped
public class CommandeManagedBean {
    List<Commande> listeCommandes;
    @EJB
    private CommandeBusiness commandeBusiness;
    public void init(){
        listeCommandes = commandeBusiness.ListerCommande();
    }
}
