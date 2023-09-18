package com.usarb.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseBody
    public Book createBook(@RequestBody BookDTO dto) {
        return bookService.createBook(dto);
    }

    @GetMapping
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }
}
