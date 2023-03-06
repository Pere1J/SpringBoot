package com.myFirstApi.first.controllers;


import com.myFirstApi.first.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    List<Book> booksDB = new ArrayList<>(
            List.of(new Book("Emma"), new Book("Tintín"))
    );


    @GetMapping("/check")
    public String check() {
        return "ok";
    }

    @GetMapping
    public List<Book> getAll() {

        return this.booksDB;
    }

    @GetMapping("/{id}")
    public Book getId(@PathVariable UUID id){
//        for (Book item:this.booksDB) {
//            if (item.getId().equals(id))
//                return item;
//
//        }
//        return null;

        var book = this.booksDB.stream()
                        .filter(item -> item.getId().equals(id))
                        .findFirst().get();
        return book;
    }
}
