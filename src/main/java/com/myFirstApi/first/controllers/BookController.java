package com.myFirstApi.first.controllers;


import com.myFirstApi.first.models.Book;
import com.myFirstApi.first.repositories.BookInMemoryRepository;
import com.myFirstApi.first.repositories.IBookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@CrossOrigin ("*")
public class BookController {

    private final IBookRepository bookInMemoryRepository;

    public BookController(IBookRepository bookInMemoryRepository) {
        this.bookInMemoryRepository = bookInMemoryRepository;
    } //Inyección de dependencias por constructor


    @GetMapping
    public List<Book> getAll() {

        return this.bookInMemoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getId(@PathVariable UUID id) {
        return this.bookInMemoryRepository.findById(id);

    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return this.bookInMemoryRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public Book deleteById(@PathVariable UUID id) {
        return this.bookInMemoryRepository.deleteItem(id);
    }
    @PutMapping("/{id}")
    public Book updateById(@PathVariable UUID id, @RequestBody Book book){
        return  this.bookInMemoryRepository.updateItem(id, book);
    }

    @GetMapping ("search")
    public List<Book> searchBy (@RequestParam("title") String title){

        return this.bookInMemoryRepository.searchItem(title);
    }

}
