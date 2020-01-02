package com.example.demo;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BooksController {

    @RequestMapping("/books")
    List<Book> getAllBooks()
    {
        return Arrays.asList(new Book(1, "Sukses selalu bro", "solihin"));
    }

}