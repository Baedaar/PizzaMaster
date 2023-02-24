package fr.eql.ai113.entity;

public class TypeIngredient {
    private Long TYPEI_id;
    private String TYPEI_intitule;

    public TypeIngredient(String TYPEI_intitule) {
        this.TYPEI_intitule = TYPEI_intitule;
    }

    public Long getTYPEI_id() {
        return TYPEI_id;
    }

    public void setTYPEI_id(Long TYPEI_id) {
        this.TYPEI_id = TYPEI_id;
    }

    public String getTYPEI_intitule() {
        return TYPEI_intitule;
    }

    public void setTYPEI_intitule(String TYPEI_intitule) {
        this.TYPEI_intitule = TYPEI_intitule;
    }
}
