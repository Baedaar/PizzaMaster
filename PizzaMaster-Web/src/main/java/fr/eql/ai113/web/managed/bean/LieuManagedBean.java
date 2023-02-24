package fr.eql.ai113.web.managed.bean;

import fr.eql.ai113.business.SiteBusiness;
import fr.eql.ai113.entity.Lieu;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "mbLieu")
@ViewScoped
public class LieuManagedBean {

    private long LIE_ID;
    private String LIE_VILLE;
    private String LIE_CODEPOSTALE;


    @EJB
    private SiteBusiness siteBusiness;

    private List<Lieu> expressions;

    private Lieu lieu;

    @PostConstruct
    public void init(){
        String forward;
        expressions = siteBusiness.getListOfLieu();
        if (expressions.isEmpty()){
            forward = "/index.xhtml?faces-redirect=true";
        }
    }
    public List<Lieu> getAllLieu() {
        expressions = siteBusiness.getListOfLieu();
        System.out.println(expressions);
        return siteBusiness.getListOfLieu();
    }
    public void creerLieu(){
        siteBusiness.insertLieu(
                new Lieu(
                        LIE_ID,
                        LIE_VILLE,
                        LIE_CODEPOSTALE
                )
        );
    }

    public void modifylieu(){
       // siteBusiness.modifyLieu();

    }

    public  void  deletelieu(){
       // siteBusiness.deleteLieu((lieu.getLIE_id()));
    }



    public long getLIE_ID() {
        return LIE_ID;
    }

    public void setLIE_ID(long LIE_ID) {
        this.LIE_ID = LIE_ID;
    }

    public String getLIE_VILLE() {
        return LIE_VILLE;
    }

    public void setLIE_VILLE(String LIE_VILLE) {
        this.LIE_VILLE = LIE_VILLE;
    }

    public String getLIE_CODEPOSTALE() {
        return LIE_CODEPOSTALE;
    }

    public void setLIE_CODEPOSTALE(String LIE_CODEPOSTALE) {
        this.LIE_CODEPOSTALE = LIE_CODEPOSTALE;
    }

    public List<Lieu> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Lieu> expressions) {
        this.expressions = expressions;
    }

}
