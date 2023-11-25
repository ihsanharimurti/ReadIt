package com.example.ta_prakppb_ihsanh.api;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ListUserResponse{

    @SerializedName("kind")
    private String kind;

    @SerializedName("totalItems")
    private int totalItems;

    @SerializedName("items")
    private List<DataItem> items;


    public void setKind(String kind){
        this.kind = kind;
    }
    public String getKind(){
        return kind;
    }

    public void setTotalItems(int totalItems){
        this.totalItems = totalItems;
    }
    public int getTotalItems(){
        return totalItems;
    }

    public void setItems(List<DataItem> items){
        this.items = items;
    }

    public List<DataItem> getItems(){
        return items;
    }


    @Override
    public String toString(){
        return
                "ListUserResponse{" +
                        "kind = '" + kind + '\'' +
                        ",totalItems = '" + totalItems + '\'' +
                        ",items = '" + items + '\'' +
                        "}";
    }
}

