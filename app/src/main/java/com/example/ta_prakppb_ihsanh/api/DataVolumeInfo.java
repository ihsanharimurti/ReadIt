package com.example.ta_prakppb_ihsanh.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataVolumeInfo {

    @SerializedName("title")
    private String title;

    @SerializedName("authors")
    private List<String> authors;

    @SerializedName("description")
    private String description;

    @SerializedName("imageLinks")
    private DataImageLinks imageLinks;



    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription(){return description;}

    public List<String> getAuthors() {
        return authors;
    }

    public void setImageLinks(DataImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }


    public DataImageLinks getImageLinks() {
        return imageLinks;
    }


//    public List<AuthorItem> getAuthors(){
//        return authors;
//    }

    public String toString(){
        StringBuilder authorsStringBuilder = new StringBuilder();
        for (String author : authors) {
            authorsStringBuilder.append(author).append(", ");
        }

// Remove the last comma and space
        if (authorsStringBuilder.length() > 0) {
            authorsStringBuilder.setLength(authorsStringBuilder.length() - 2);
        }

        return "DataItem{" +
                "title='" + title + '\'' +
                ", authors=" + authorsStringBuilder.toString() +
                "}";

    }


}
