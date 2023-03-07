package com.myFirstApi.first.models;

import java.util.UUID;

public class Book {
    private String title;
    private UUID id;
    private boolean isLoaned;
    private String author;
    private String coverUrl;

    public Book() {
        this.id = UUID.randomUUID();
    }

    public Book(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
    }

    public Book(String title, boolean isLoaned, String author, String coverUrl) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.isLoaned = isLoaned;
        this.author = author;
        this.coverUrl= coverUrl;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

