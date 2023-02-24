package fr.eql.ai113.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Produit implements Serializable {
    private Long TYPEP_ID;
    private Long TYPEC_ID;
    private Integer PROD_id;
    private String PROD_intitule;
    private String PROD_image;
    private Float PROD_tempsPreparation;
    private LocalDate PROD_dateAjout;
    private Float PROD_volume;
    private LocalDate PROD_dateRetrait;
    private String TYPEP_intitule;
    private String TYPEC_type;
    private Float TYPEC_contenance;
    private List<Ingredient> listeIngredients;
    private List<Constituer> listeConstituer;


    public Produit(Long TYPEP_ID, Long TYPEC_ID, String PROD_intitule, String PROD_image,
                   Float PROD_tempsPreparation, LocalDate PROD_dateAjout,
                   Float PROD_volume) {
        this.TYPEP_ID = TYPEP_ID;
        this.TYPEC_ID = TYPEC_ID;
        this.PROD_intitule = PROD_intitule;
        this.PROD_image = PROD_image;
        this.PROD_tempsPreparation = PROD_tempsPreparation;
        this.PROD_dateAjout = PROD_dateAjout;
        this.PROD_volume = PROD_volume;
    }
    public Produit(Integer PROD_ID ,Long TYPEP_ID, Long TYPEC_ID, String PROD_intitule, String PROD_image,
                   Float PROD_tempsPreparation, LocalDate PROD_dateAjout,
                   Float PROD_volume) {
        this.PROD_id = PROD_ID;
        this.TYPEP_ID = TYPEP_ID;
        this.TYPEC_ID = TYPEC_ID;
        this.PROD_intitule = PROD_intitule;
        this.PROD_image = PROD_image;
        this.PROD_tempsPreparation = PROD_tempsPreparation;
        this.PROD_dateAjout = PROD_dateAjout;
        this.PROD_volume = PROD_volume;
    }

    public Long getTYPEP_ID() {
        return TYPEP_ID;
    }

    public void setTYPEP_ID(Long TYPEP_ID) {
        this.TYPEP_ID = TYPEP_ID;
    }

    public Long getTYPEC_ID() {
        return TYPEC_ID;
    }

    public void setTYPEC_ID(Long TYPEC_ID) {
        this.TYPEC_ID = TYPEC_ID;
    }

    public Integer getPROD_id() {
        return PROD_id;
    }

    public void setPROD_id(Integer PROD_id) {
        this.PROD_id = PROD_id;
    }

    public String getPROD_intitule() {
        return PROD_intitule;
    }

    public void setPROD_intitule(String PROD_intitule) {
        this.PROD_intitule = PROD_intitule;
    }

    public String getPROD_image() {
        return PROD_image;
    }

    public void setPROD_image(String PROD_image) {
        this.PROD_image = PROD_image;
    }

    public Float getPROD_tempsPreparation() {
        return PROD_tempsPreparation;
    }

    public void setPROD_tempsPreparation(Float PROD_tempsPreparation) {
        this.PROD_tempsPreparation = PROD_tempsPreparation;
    }

    public LocalDate getPROD_dateAjout() {
        return PROD_dateAjout;
    }

    public void setPROD_dateAjout(LocalDate PROD_dateAjout) {
        this.PROD_dateAjout = PROD_dateAjout;
    }

    public Float getPROD_volume() {
        return PROD_volume;
    }

    public void setPROD_volume(Float PROD_volume) {
        this.PROD_volume = PROD_volume;
    }

    public LocalDate getPROD_dateRetrait() {
        return PROD_dateRetrait;
    }

    public void setPROD_dateRetrait(LocalDate PROD_dateRetrait) {
        this.PROD_dateRetrait = PROD_dateRetrait;
    }

    public String getTYPEP_intitule() {
        return TYPEP_intitule;
    }

    public void setTYPEP_intitule(String TYPEP_intitule) {
        this.TYPEP_intitule = TYPEP_intitule;
    }

    public String getTYPEC_type() {
        return TYPEC_type;
    }

    public void setTYPEC_type(String TYPEC_type) {
        this.TYPEC_type = TYPEC_type;
    }

    public Float getTYPEC_contenance() {
        return TYPEC_contenance;
    }

    public void setTYPEC_contenance(Float TYPEC_contenance) {
        this.TYPEC_contenance = TYPEC_contenance;
    }

    public List<Ingredient> getListeIngredients() {
        return listeIngredients;
    }

    public void setListeIngredients(List<Ingredient> listeIngredients) {
        this.listeIngredients = listeIngredients;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "TYPEP_ID=" + TYPEP_ID +
                ", TYPEC_ID=" + TYPEC_ID +
                ", PROD_id=" + PROD_id +
                ", PROD_intitule='" + PROD_intitule + '\'' +
                ", PROD_image='" + PROD_image + '\'' +
                ", PROD_tempsPreparation=" + PROD_tempsPreparation +
                ", PROD_dateAjout=" + PROD_dateAjout +
                ", PROD_volume=" + PROD_volume +
                ", PROD_dateRetrait=" + PROD_dateRetrait +
                ", TYPEP_intitule='" + TYPEP_intitule + '\'' +
                ", TYPEC_type='" + TYPEC_type + '\'' +
                ", TYPEC_contenance=" + TYPEC_contenance +
                '}';
    }
}
