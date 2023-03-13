package com.myFirstApi.first.repositories;

import com.myFirstApi.first.models.Book;

import java.util.List;
import java.util.UUID;

public interface IBookRepository {
    List<Book> findAll();

    Book findById(UUID id);

    Book save(Book book);

    Book deleteItem(UUID id);

    Book updateItem(UUID id, Book book);

    List<Book> searchItem(String title);
}
