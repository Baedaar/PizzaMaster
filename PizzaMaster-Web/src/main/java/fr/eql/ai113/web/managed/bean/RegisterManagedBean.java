package fr.eql.ai113.web.managed.bean;

import fr.eql.ai113.business.RegisterBusiness;
import fr.eql.ai113.entity.Client;
import fr.eql.ai113.entity.enums.Genre;
import fr.eql.ai113.web.managed.bean.utils.StringUtils;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ManagedBean(name = "mbRegister")
@ViewScoped
public class RegisterManagedBean {

    private Client expression;
    private String newCLI_email;
    private String newCLI_nom;
    private String newCLI_MotDePasse;
    private String newCLI_prenom;
    private Date newClI_dateDeNaissance;
    private Genre newGenre;
    private String newGEN;
    private List<String> genres = new ArrayList<>();


    @EJB
    private RegisterBusiness registerBusiness;

    public void setNewGEN(String newGEN) {
        this.newGEN = newGEN;
    }


//    public long stringEnum(Genre genre) {
//        genre = newGenre;
//        long idGenre = genre.ordinal() + 1;
//
//        return idGenre;
//    }

    public void insertClient() {
        String forward;

        switch (newGenre) {
            case Homme:
                Client newClient = new Client(
                        1,
                        newCLI_email,
                        newCLI_MotDePasse,
                        newCLI_nom,
                        newClI_dateDeNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        newCLI_prenom
                );
                registerBusiness.insertClient(newClient);
                if (newClient.equals(null)) {
                    forward = "/index.xhtml?faces-redirect=false";
                } else {
                    forward = "/index.xhtml?faces-redirect=false";
                }
                break;
            case Femme:
                newClient = new Client(
                        2,
                        newCLI_email,
                        newCLI_MotDePasse,
                        newCLI_nom,
                        newClI_dateDeNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        newCLI_prenom
                );
                registerBusiness.insertClient(newClient);
                if (newClient.equals(null)) {
                    forward = "/index.xhtml?faces-redirect=false";
                } else {
                    forward = "/index.xhtml?faces-redirect=false";
                }
                break;

            default:
                newClient = new Client(
                        3,
                        newCLI_email,
                        newCLI_MotDePasse,
                        newCLI_nom,
                        newClI_dateDeNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        newCLI_prenom
                );
                registerBusiness.insertClient(newClient);
                if (newClient.equals(null)) {
                    forward = "/index.xhtml?faces-redirect=false";
                } else {
                    forward = "/index.xhtml?faces-redirect=false";
                }
        }

    }


    public List displayGenre() {
        registerBusiness.displayGenreList(genres);
        genres = Stream.of(Genre.values())
                .map(breed -> StringUtils.firstLetterCapitalized(breed.toString())).collect(Collectors.toList());
        return genres;
    }


    public String getNewCLI_email() {
        return newCLI_email;
    }

    public void setNewCLI_email(String newCLI_email) {
        this.newCLI_email = newCLI_email;
    }

    public String getNewCLI_nom() {
        return newCLI_nom;
    }

    public void setNewCLI_nom(String newCLI_nom) {
        this.newCLI_nom = newCLI_nom;
    }

    public String getNewCLI_MotDePasse() {
        return newCLI_MotDePasse;
    }

    public void setNewCLI_MotDePasse(String newCLI_MotDePasse) {
        this.newCLI_MotDePasse = newCLI_MotDePasse;
    }

    public String getNewCLI_prenom() {
        return newCLI_prenom;
    }

    public void setNewCLI_prenom(String newCLI_prenom) {
        this.newCLI_prenom = newCLI_prenom;
    }

    public String getNewGEN() {
        return newGEN;
    }


    public Date getNewClI_dateDeNaissance() {
        return newClI_dateDeNaissance;
    }

    public void setNewClI_dateDeNaissance(Date newClI_dateDeNaissance) {
        this.newClI_dateDeNaissance = newClI_dateDeNaissance;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Genre getNewGenre() {
        return newGenre;
    }

    public void setNewGenre(Genre newGenre) {
        this.newGenre = newGenre;
    }

}

