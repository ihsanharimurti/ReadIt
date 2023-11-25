package com.example.ta_prakppb_ihsanh;

import java.util.List;

//public class Book {
//
//    private String title, thumbnail, authors;
//
//    public Book(String title, String thumbnail, String authors){
//        this.title=title;
//        this.thumbnail=thumbnail;
//        this.authors=authors;
//    }
//
//    public String getAuthors() {
//        return authors;
//    }
//
//    public String getThumbnail() {
//        return thumbnail;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//}
public class Book {
    private String title;
    private List<String> authors;
    private String description;
    private String thumbnailUrl;

    // Add any other necessary fields

    // Constructor
    public Book(String title, List<String> authors, String description, String thumbnailUrl) {
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
    }

    // Add getters
    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
