package com.example.jeonwon.binteum;

/**
 * Created by HeeJack on 2018-05-28.
 */

public class User {
    String ID, PW, GENDER, UNIV, FIELD, EMAIL,NAME;
    int UID;

    public User(){};

    public User(int UID, String ID, String PW, String GENDER, String UNIV, String FIElD, String EMAIL, String NAME){
        this.UID = UID;
        this.NAME = NAME;
        this.ID = ID;
        this.PW = PW;
        this.GENDER = GENDER;
        this.UNIV = UNIV;
        this.FIELD = FIElD;
        this.EMAIL = EMAIL;
    };

    public void setUID(int UID){
        this.UID = UID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setNAME(String NAME){
        this.NAME = NAME;
    }
    public void setPW(String PW){
        this.PW = PW;
    }
    public void setGENDER(String GENDER){
        this.GENDER = GENDER;
    }
    public void setUNIV(String UNIV){
        this.UNIV = UNIV;
    }
    public void setFIELD(String FIELD){
        this.FIELD = FIELD;
    }
    public void setEMAIL(String EMAIL){
        this.EMAIL = EMAIL;
    }
    public int getUID(){return this.UID;}
    public String getID(){return this.ID;}
    public String getPW(){return this.PW;}
    public String getNAME(){return this.NAME;}
    public String getGENDER(){return this.GENDER;}
    public String getUNIV(){return this.UNIV;}
    public String getFIELD(){return this.FIELD;}
    public String getEMAIL(){return this.EMAIL;}





}
