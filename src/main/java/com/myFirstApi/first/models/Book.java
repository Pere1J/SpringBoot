package com.myFirstApi.first.models;

import java.util.UUID;

public class Book {
    private String title;
    private UUID id;


    public Book(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
