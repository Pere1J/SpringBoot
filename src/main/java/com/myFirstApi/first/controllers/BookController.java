package com.myFirstApi.first.controllers;


import com.myFirstApi.first.models.Book;
import com.myFirstApi.first.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
@CrossOrigin ("*")
public class BookController {

    private final BookRepository bookRepository = new BookRepository();


    @GetMapping("/check")
    public String check() {
        return "ok";
    }

    @GetMapping
    public List<Book> getAll() {

        return this.bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getId(@PathVariable UUID id) {
        return this.bookRepository.findById(id);

    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public Book deleteById(@PathVariable UUID id) {
        return this.bookRepository.deleteItem(id);
    }
    @PutMapping("/{id}")
    public Book updateById(@PathVariable UUID id, @RequestBody Book book){
        return  this.bookRepository.updateItem(id, book);
    }

    @GetMapping ("search")
    public List<Book> searchBy (@RequestParam("title") String title){

        return this.bookRepository.searchItem(title);
    }

}
