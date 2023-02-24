package fr.eql.ai113.entity;

import java.time.LocalDate;

public class ComposerCarte {
    Integer COMPC_ID;
    Integer CAR_ID;
    Integer PROD_ID;
    LocalDate COMPC_date;
    Float COMPC_prix;
    Integer COMPC_quantite;

    public ComposerCarte(Integer CAR_ID, Integer PROD_ID, LocalDate COMPC_date, Float COMPC_prix, Integer COMPC_quantite) {
        this.CAR_ID = CAR_ID;
        this.PROD_ID = PROD_ID;
        this.COMPC_date = COMPC_date;
        this.COMPC_prix = COMPC_prix;
        this.COMPC_quantite = COMPC_quantite;
    }
}
