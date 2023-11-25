package com.example.ta_prakppb_ihsanh.api;

import com.google.gson.annotations.SerializedName;

public class DataSaleInfo {



    @SerializedName("buyLink")
    private int buyLink;


    public void setBuyLink(int buyLink){
        this.buyLink = buyLink;
    }
    public int getBuyLink(){
        return buyLink;
    }

    public String toString(){
        return
                "DataItem{" +
                        ",buyLink = '" + buyLink + '\'' +
                        "}";
    }


}
