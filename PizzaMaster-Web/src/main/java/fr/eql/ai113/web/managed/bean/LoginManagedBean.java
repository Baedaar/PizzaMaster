package fr.eql.ai113.web.managed.bean;

import fr.eql.ai113.business.LoginBusiness;
import fr.eql.ai113.entity.Client;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "mbLogin")
@SessionScoped
public class LoginManagedBean {


    private String email;
    private String password;
    public Client connectedClient;

    @EJB
    private LoginBusiness loginBusiness;

    public String connect() {
        String forward;
        connectedClient = loginBusiness.authentification(email, password);
        if (connectedClient != null) {
            forward = "/index.xhtml?faces-redirect=true";
        } else {
            FacesMessage facesMessage = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "Email et/ou mot de passe incorrect(s)",
                    "Email et/ou mot de passe incorrect(s)"
            );
            FacesContext.getCurrentInstance().addMessage("loginForm:inpEmail", facesMessage);
            FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", facesMessage);
            forward = "/login.xhtml?faces-redirect=false";
        }
        return forward;
    }

    public boolean isConnected() {
        return connectedClient != null;
    }

    public void authorise() {
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler)
                context.getApplication().getNavigationHandler();
        if (!isConnected()) {
            handler.performNavigation("/login.xhtml?faces-redirect=true");
        }
    }

    public String disconnect() {
        HttpSession session = (HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(true);
        session.invalidate();
        email = "";
        password = "";
        connectedClient = null;
        return "/index.xhtml?faces-redirect=true";
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client getConnectedClient() {
        return connectedClient;
    }

    public void setConnectedClient(Client connectedClient) {
        this.connectedClient = connectedClient;
    }
}


