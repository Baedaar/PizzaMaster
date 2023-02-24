package fr.eql.ai113.entity;



import fr.eql.ai113.entity.enums.Types;

import java.io.Serializable;

public class Site extends Lieu implements Serializable {

    private long SIT_id;
    private String SIT_nom;
    private String SIT_nomRue;
    private String SIT_nomVoie;
    private String SIT_telephone;
    private Types types;




    public Site(long SIT_id,Long LIE_id,Types types,String SIT_nom, String SIT_nomRue,String SIT_nomVoie, String SIT_telephone)
    {
        super(LIE_id);
        this.SIT_id=SIT_id;
        this.SIT_nom = SIT_nom;
        this.SIT_nomRue = SIT_nomRue;
        this.SIT_nomVoie = SIT_nomVoie;
        this.SIT_telephone = SIT_telephone;
        this.types=types;
    }

    public Site(long SIT_id,Long LIE_id,String SIT_nom, String SIT_nomRue,String SIT_nomVoie, String SIT_telephone)
    {
        super(LIE_id);
        this.SIT_id=SIT_id;
        this.SIT_nom = SIT_nom;
        this.SIT_nomRue = SIT_nomRue;
        this.SIT_nomVoie = SIT_nomVoie;
        this.SIT_telephone = SIT_telephone;
    }
    public Site(Long LIE_id,Types types,String SIT_nom, String SIT_nomRue,String SIT_nomVoie, String SIT_telephone)
    {
        super(LIE_id);
        this.types=types;
        this.SIT_nom = SIT_nom;
        this.SIT_nomRue = SIT_nomRue;
        this.SIT_nomVoie = SIT_nomVoie;
        this.SIT_telephone = SIT_telephone;
    }




    public String getSIT_nom() {
        return SIT_nom;
    }

    public void setSIT_nom(String SIT_nom) {
        this.SIT_nom = SIT_nom;
    }

    public String getSIT_nomRue() {
        return SIT_nomRue;
    }

    public void setSIT_nomRue(String SIT_nomRue) {
        this.SIT_nomRue = SIT_nomRue;
    }

    public String getSIT_nomVoie() {
        return SIT_nomVoie;
    }

    public void setSIT_nomVoie(String SIT_nomVoie) {
        this.SIT_nomVoie = SIT_nomVoie;
    }

    public String getSIT_telephone() {
        return SIT_telephone;
    }

    public void setSIT_telephone(String SIT_telephone) {
        this.SIT_telephone = SIT_telephone;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public long getSIT_id() {
        return SIT_id;
    }

    public void setSIT_id(long SIT_id) {
        this.SIT_id = SIT_id;
    }
}
