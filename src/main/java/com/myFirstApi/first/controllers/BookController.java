package com.myFirstApi.first.controllers;


import com.myFirstApi.first.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@CrossOrigin ("*")
public class BookController {

    List<Book> booksDB = new ArrayList<>(
            //List.of(new Book("Emma"), new Book("Tintín"))
            List.of(new Book("Emma",true,"Jane Austen", "https://kbimages1-a.akamaihd.net/1ea81b28-2fa1-4796-b9b0-710123b48227/353/569/90/False/emma-503.jpg"),
                    new Book("Tintín", false, "Hergè", "https://zephyrum.es/348-large_default/tintin-i-milu-gran-album-de-jocs.jpg"),
                    new Book("Conan", false, "Howard", "https://m.media-amazon.com/images/I/712C4wexOxL.jpg"),
                    new Book("Drácula", true, "Bram Stoker", "https://imagessl6.casadellibro.com/a/l/t7/36/9788415618836.jpg "),
                    new Book("Tarzán", false, "Edward Rice Burroughs", "https://pictures.abebooks.com/isbn/9780307131942-es.jpg"),
                    new Book("Capital", false, "Karl Marx", "https://pictures.abebooks.com/inventory/md/md30822975656.jpg"),
                    new Book("Aurora", true, "Sandra Moya", "https://f7099cdac3ad9a351ae3-74c3dcaca50fe6cfec786b085d2f6908.ssl.cf5.rackcdn.com/books/images/lantia_cover_622af53a3dd25_360.jpg"),
                    new Book("Un amor", false, "Sara Mesa", "https://www.anagrama-ed.es/uploads/media/portadas/0001/25/4de1878d73446124ee5b4e6c48b6f0fee6d8115a.jpeg"),
                    new Book("Ivanhoe", false, "Walter Scott", "https://images.cdn2.buscalibre.com/fit-in/360x360/b5/bc/b5bcde278d2b5a97eb4b492c3361abec.jpg")
            )
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
    public Book getId(@PathVariable UUID id) {
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

    @PostMapping
    public Book create(@RequestBody Book book) {
        this.booksDB.add(book);
        return book;
    }

    @DeleteMapping("/{id}")
    public Book deleteById(@PathVariable UUID id) {
        for (Book item : this.booksDB) {
            if (item.getId().equals(id)) {
                this.booksDB.remove(item);
                return item;
            }

        } return null;
    }
    @PutMapping("/{id}")
    public Book updateById(@PathVariable UUID id, @RequestBody Book book){
        for (Book item:this.booksDB
             ) { if (item.getId().equals(id)){
                 item.setTitle(book.getTitle());
                 return item;
        }
            
        }
        return null;

    }

}
