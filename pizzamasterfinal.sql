

drop table if exists CARTE;



drop table if exists CLIENT;



drop table if exists COMMANDE;



drop table if exists COMPOSER_CARTE;


drop table if exists CONSTITUER;

drop table if exists GENRE;



drop table if exists INGREDIENT;



drop table if exists INGREDIENT_MODIF;

drop table if exists LIEU;



drop table if exists LIGNE_COMMANDE;



drop table if exists LISTE_ADRESSE;



drop table if exists LIVREUR;

drop table if exists MODE_PAIEMENT;

drop table if exists MODE_RETRAIT;



drop table if exists POINTAGE;



drop table if exists PRODUIT;




drop table if exists SITE;



drop table if exists STOCK;

drop table if exists TAUX_TVA;

drop table if exists TYPE_CONTENANT;

drop table if exists TYPE_INGREDIENT;

drop table if exists TYPE_PRODUIT;

drop table if exists TYPE_SITE;

/*==============================================================*/
/* Table : CARTE                                                */
/*==============================================================*/
create table CARTE
(
   CAR_ID               int not null auto_increment,
   CAR_INTITULECATEGORIE text,
   CAR_DATEDEBUTVENTE   date,
   CAR_DATEFINVENTE     date,
   CAR_PRIXAJOUT        float(16),
   primary key (CAR_ID)
);

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
create table CLIENT
(
   CLI_ID               int not null auto_increment,
   GEN_ID               int,
   COM_REFERENCE        int not null,
   CLI_EMAIL            text,
   CLI_MOTDEPASSE       text,
   CLI_NOM              text,
   CLI_TELEPHONE        text,
   CLI_DATENAISSANCE    date,
   CLI_PRENOM           text,
   CLI_DATEINSCRIPTION  date,
   CLI_AUTHENTIFIE      date,
   primary key (CLI_ID)
);

/*==============================================================*/
/* Table : COMMANDE                                             */
/*==============================================================*/
create table COMMANDE
(
   COM_REFERENCE        int not null auto_increment,
   TAU_ID               int not null,
   MODER_ID             int not null,
   CAR_ID               int not null,
   LIV_ID               int not null,
   MODP_ID              int not null,
   SIT_ID               int not null,
   COM_DATE             date,
   COM_DATEHEUREVALIDE  date,
   COM_HEUREDEBUTPREPA  time,
   COM_HEUREFINPREPA    time,
   COM_HEUREPRISECOMMANDE time,
   COM_HEUREREMISECOMMANDELIVREUR time,
   COM_HEUREVALIDATIONPAIEMENT time,
   COM_HEUREFINDELIVRAISON time,
   primary key (COM_REFERENCE)
);

/*==============================================================*/
/* Table : COMPOSER_CARTE                                       */
/*==============================================================*/
create table COMPOSER_CARTE
(
   COMPC_ID             int not null auto_increment,
   CAR_ID               int not null,
   PROD_ID              int not null,
   COMPC_DATE           date,
   COMPC_PRIX           float(16),
   COMPC_QUANTITE       int,
   primary key (COMPC_ID)
);

/*==============================================================*/
/* Table : CONSTITUER                                           */
/*==============================================================*/
create table CONSTITUER
(
   CONS_ID              int not null auto_increment,
   PROD_ID              int not null,
   ING_ID               int not null,
   primary key (CONS_ID)
);

/*==============================================================*/
/* Table : GENRE                                                */
/*==============================================================*/
create table GENRE
(
   GEN_ID               int not null auto_increment,
   GEN_INTITULE         text,
   primary key (GEN_ID)
);

/*==============================================================*/
/* Table : INGREDIENT                                           */
/*==============================================================*/
create table INGREDIENT
(
   ING_ID               int not null auto_increment,
   TYPEI_ID             int not null,
   ING_INTITULE         text,
   ING_COMPLEMENTAIRE   bool,
   ING_DATERETRAIT      date,
   primary key (ING_ID)
);

/*==============================================================*/
/* Table : INGREDIENT_MODIF                                     */
/*==============================================================*/
create table INGREDIENT_MODIF
(
   INGM_MOD             int not null auto_increment,
   ING_ID               int not null,
   LIGC_ID              int not null,
   INGM_MODIFICATION    bool,
   primary key (INGM_MOD)
);

/*==============================================================*/
/* Table : LIEU                                                 */
/*==============================================================*/
create table LIEU
(
   LIE_ID               int not null auto_increment,
   LIE_VILLE            text,
   LIE_CODEPOSTALE      text,
   primary key (LIE_ID)
);

/*==============================================================*/
/* Table : LIGNE_COMMANDE                                       */
/*==============================================================*/
create table LIGNE_COMMANDE
(
   LIGC_ID              int not null auto_increment,
   COM_REFERENCE        int not null,
   PROD_ID              int not null,
   LIGC_QUANTITE        int,
   primary key (LIGC_ID)
);

/*==============================================================*/
/* Table : LISTE_ADRESSE                                        */
/*==============================================================*/
create table LISTE_ADRESSE
(
   LISA_ID              int not null auto_increment,
   CLI_ID               int not null,
   LIE_ID               int not null,
   LISA_NUMERORUE       int,
   LISA_NOMVOIE         text,
   LISA_ESCALIER        text,
   LISA_ETAGE           smallint,
   LISA_PORTE           text,
   primary key (LISA_ID)
);

/*==============================================================*/
/* Table : LIVREUR                                              */
/*==============================================================*/
create table LIVREUR
(
   LIV_ID               int not null auto_increment,
   SIT_ID               int not null,
   LIV_NOM              text,
   LIV_PRENOM           text,
   LIV_TELEPHONE        text,
   LIV_NOMUTILISATEUR   text,
   LIV_EMAIL            text,
   LIV_MOTDEPASSE       text,
   primary key (LIV_ID)
);

/*==============================================================*/
/* Table : MODE_PAIEMENT                                        */
/*==============================================================*/
create table MODE_PAIEMENT
(
   MODP_ID              int not null auto_increment,
   MODP_TYPE            text,
   primary key (MODP_ID)
);

/*==============================================================*/
/* Table : MODE_RETRAIT                                         */
/*==============================================================*/
create table MODE_RETRAIT
(
   MODER_ID             int not null auto_increment,
   MODER_MODE           text,
   primary key (MODER_ID)
);

/*==============================================================*/
/* Table : POINTAGE                                             */
/*==============================================================*/
create table POINTAGE
(
   POI_ID               int not null auto_increment,
   LIV_ID               int not null,
   POI_DATE             date,
   POI_HEUREDEBUT       date,
   POI_HEUREFIN         date,
   primary key (POI_ID)
);

/*==============================================================*/
/* Table : PRODUIT                                              */
/*==============================================================*/
create table PRODUIT
(
   PROD_ID              int not null auto_increment,
   TYPEP_ID             int not null,
   TYPEC_ID             int not null,
   PROD_INTITULE        text,
   PROD_IMAGE           text,
   PROD_TEMPSPREPARATION float(16),
   PROD_DATEAJOUT       date,
   PROD_VOLUME          float(16),
   PROD_DATERETRAIT     date,
   primary key (PROD_ID)
);

/*==============================================================*/
/* Table : SITE                                                 */
/*==============================================================*/
create table SITE
(
   SIT_ID               int not null auto_increment,
   LIE_ID               int,
   TYPES_ID             int,
   SIT_NOM              text,
   SIT_NUMERORUE        text,
   SIT_NOMVOIE          text,
   SIT_TELEPHONE        text,
   primary key (SIT_ID)
);

/*==============================================================*/
/* Table : STOCK                                                */
/*==============================================================*/
create table STOCK
(
   STO_ID               int not null auto_increment,
   PROD_ID              int not null,
   STO_INTITULE         text,
   STO_QUANTITE         bigint,
   STO_SEUIL            bigint,
   STO_DATEENTREE       date,
   STO_DESCRIPTION      date,
   primary key (STO_ID)
);

/*==============================================================*/
/* Table : TAUX_TVA                                             */
/*==============================================================*/
create table TAUX_TVA
(
   TAU_ID               int not null auto_increment,
   TAU_TAUX             float(16),
   TAU_DATEVALIDITE     date,
   primary key (TAU_ID)
);

/*==============================================================*/
/* Table : TYPE_CONTENANT                                       */
/*==============================================================*/
create table TYPE_CONTENANT
(
   TYPEC_ID             int not null auto_increment,
   TYPEC_TYPE           text,
   TYPEC_CONTENANCE     float(16),
   primary key (TYPEC_ID)
);

/*==============================================================*/
/* Table : TYPE_INGREDIENT                                      */
/*==============================================================*/
create table TYPE_INGREDIENT
(
   TYPEI_ID             int not null auto_increment,
   TYPEI_INTITULE       text,
   primary key (TYPEI_ID)
);

/*==============================================================*/
/* Table : TYPE_PRODUIT                                         */
/*==============================================================*/
create table TYPE_PRODUIT
(
   TYPEP_ID             int not null auto_increment,
   TYPEP_INTITULE       text,
   primary key (TYPEP_ID)
);

/*==============================================================*/
/* Table : TYPE_SITE                                            */
/*==============================================================*/
create table TYPE_SITE
(
   TYPES_ID             int not null auto_increment,
   TYPES_TYPE           text,
   primary key (TYPES_ID)
);

alter table CLIENT add constraint FK_CLIENT_GENRER_GENRE foreign key (GEN_ID)
      references GENRE (GEN_ID) on delete restrict on update restrict;

alter table CLIENT add constraint FK_CLIENT_PASSER_COMMANDE foreign key (COM_REFERENCE)
      references COMMANDE (COM_REFERENCE) on delete restrict on update restrict;

alter table COMMANDE add constraint FK_COMMANDE_APPLIQUER_TAUX_TVA foreign key (TAU_ID)
      references TAUX_TVA (TAU_ID) on delete restrict on update restrict;

alter table COMMANDE add constraint FK_COMMANDE_ATTRIBUER_LIVREUR foreign key (LIV_ID)
      references LIVREUR (LIV_ID) on delete restrict on update restrict;

alter table COMMANDE add constraint FK_COMMANDE_CORRESPON_CARTE foreign key (CAR_ID)
      references CARTE (CAR_ID) on delete restrict on update restrict;

alter table COMMANDE add constraint FK_COMMANDE_DISTRIBUE_MODE_RET foreign key (MODER_ID)
      references MODE_RETRAIT (MODER_ID) on delete restrict on update restrict;

alter table COMMANDE add constraint FK_COMMANDE_PAYER_MODE_PAI foreign key (MODP_ID)
      references MODE_PAIEMENT (MODP_ID) on delete restrict on update restrict;

alter table COMMANDE add constraint FK_COMMANDE_SITUER_SITE foreign key (SIT_ID)
      references SITE (SIT_ID) on delete restrict on update restrict;

alter table COMPOSER_CARTE add constraint FK_COMPOSER_COMPOSER__PRODUIT foreign key (PROD_ID)
      references PRODUIT (PROD_ID) on delete restrict on update restrict;

alter table COMPOSER_CARTE add constraint FK_COMPOSER_COMPOSER__CARTE foreign key (CAR_ID)
      references CARTE (CAR_ID) on delete restrict on update restrict;

alter table CONSTITUER add constraint FK_CONSTITU_CONSTITUE_INGREDIE foreign key (ING_ID)
      references INGREDIENT (ING_ID) on delete restrict on update restrict;

alter table CONSTITUER add constraint FK_CONSTITU_CONSTITUE_PRODUIT foreign key (PROD_ID)
      references PRODUIT (PROD_ID) on delete restrict on update restrict;

alter table INGREDIENT add constraint FK_INGREDIE_CLASSER_TYPE_ING foreign key (TYPEI_ID)
      references TYPE_INGREDIENT (TYPEI_ID) on delete restrict on update restrict;

alter table INGREDIENT_MODIF add constraint FK_INGREDIE_MODIFIER__LIGNE_CO foreign key (LIGC_ID)
      references LIGNE_COMMANDE (LIGC_ID) on delete restrict on update restrict;

alter table INGREDIENT_MODIF add constraint FK_INGREDIE_MODIFIER__INGREDIE foreign key (ING_ID)
      references INGREDIENT (ING_ID) on delete restrict on update restrict;

alter table LIGNE_COMMANDE add constraint FK_LIGNE_CO_AJOUTER_C_COMMANDE foreign key (COM_REFERENCE)
      references COMMANDE (COM_REFERENCE) on delete restrict on update restrict;

alter table LIGNE_COMMANDE add constraint FK_LIGNE_CO_AJOUTER_P_PRODUIT foreign key (PROD_ID)
      references PRODUIT (PROD_ID) on delete restrict on update restrict;

alter table LISTE_ADRESSE add constraint FK_LISTE_AD_LOCALISER_CLIENT foreign key (CLI_ID)
      references CLIENT (CLI_ID) on delete restrict on update restrict;

alter table LISTE_ADRESSE add constraint FK_LISTE_AD_LOCALISER_LIEU foreign key (LIE_ID)
      references LIEU (LIE_ID) on delete restrict on update restrict;

alter table LIVREUR add constraint FK_LIVREUR_TRAVAILLE_SITE foreign key (SIT_ID)
      references SITE (SIT_ID) on delete restrict on update restrict;

alter table POINTAGE add constraint FK_POINTAGE_DECLARER_LIVREUR foreign key (LIV_ID)
      references LIVREUR (LIV_ID) on delete restrict on update restrict;

alter table PRODUIT add constraint FK_PRODUIT_CATEGORIS_TYPE_PRO foreign key (TYPEP_ID)
      references TYPE_PRODUIT (TYPEP_ID) on delete restrict on update restrict;

alter table PRODUIT add constraint FK_PRODUIT_CONTENIR_TYPE_CON foreign key (TYPEC_ID)
      references TYPE_CONTENANT (TYPEC_ID) on delete restrict on update restrict;

alter table SITE add constraint FK_SITE_APPARTENI_LIEU foreign key (LIE_ID)
      references LIEU (LIE_ID) on delete restrict on update restrict;

alter table SITE add constraint FK_SITE_DEFINIR_TYPE_SIT foreign key (TYPES_ID)
      references TYPE_SITE (TYPES_ID) on delete restrict on update restrict;

alter table STOCK add constraint FK_STOCK_STOCKER_PRODUIT foreign key (PROD_ID)
      references PRODUIT (PROD_ID) on delete restrict on update restrict;

