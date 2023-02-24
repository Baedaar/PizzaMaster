package fr.eql.ai113.entity;

import java.io.Serializable;

public class Constituer implements Serializable {
    private Integer PROD_id;
    private Integer ING_id;

    public Constituer() {
    }

    public Constituer(Integer PROD_id, Integer ING_id) {
        this.PROD_id = PROD_id;
        this.ING_id = ING_id;
    }

    public Integer getPROD_id() {
        return PROD_id;
    }

    public void setPROD_id(Integer PROD_id) {
        this.PROD_id = PROD_id;
    }

    public Integer getING_id() {
        return ING_id;
    }

    public void setING_id(Integer ING_id) {
        this.ING_id = ING_id;
    }

}
