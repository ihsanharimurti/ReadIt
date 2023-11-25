package com.example.ta_prakppb_ihsanh.api;

import com.google.gson.annotations.SerializedName;

public class DataImageLinks {
    @SerializedName("thumbnail")
    private String smallThumbnail;



    public void setSmallThumbnail(String smallThumbnail){
        this.smallThumbnail = smallThumbnail;
    }
    public String getSmallThumbnail(){
        return smallThumbnail;
    }

    public String toString(){
        return
                "DataItem{" +
                        ",Thumbnail = '" + smallThumbnail + '\'' +
                        "}";
    }



}
