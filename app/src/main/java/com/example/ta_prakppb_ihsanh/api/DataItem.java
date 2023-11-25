package com.example.ta_prakppb_ihsanh.api;

import com.google.gson.annotations.SerializedName;

public class DataItem {

    @SerializedName("kind")
    private String kind;

    @SerializedName("id")
    private String id;

    @SerializedName("etag")
    private String etag;

    @SerializedName("selfLink")
    private String selfLink;

    @SerializedName("volumeInfo")
    private DataVolumeInfo volumeInfo; // Adjust the type based on your actual class structure

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getEtag() {
        return etag;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setVolumeInfo(DataVolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public DataVolumeInfo getVolumeInfoClass() {
        return volumeInfo;
    }






    @Override
    public String toString(){
        return
                "DataItem{" +
                        ",id = '" + id + '\'' +
                        ",volumeInfo = '" + volumeInfo + '\'' +
                        "}";
    }

    public String getName() {
        return null;
    }
}
