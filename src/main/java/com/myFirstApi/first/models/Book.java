package com.myFirstApi.first.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity


public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private UUID uuid;
    private boolean isLoaned;
    private String author;
    private String coverUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book() {
        this.uuid = UUID.randomUUID();
    }

    public Book(String title) {
        this.uuid = UUID.randomUUID();
        this.title = title;
    }

    public Book(String title, boolean isLoaned, String author, String coverUrl) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.isLoaned = isLoaned;
        this.author = author;
        this.coverUrl= coverUrl;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsLoaned() {
        return isLoaned;
    }

    public String getAuthor() {
        return author;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setIsLoaned(boolean isLoaned) {
        this.isLoaned = isLoaned;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}

