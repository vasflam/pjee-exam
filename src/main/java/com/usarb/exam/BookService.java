package com.usarb.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        Optional<Book> result = bookRepository.findById(id);
        return result.orElse(null);
    }

    public Book createBook(BookDTO dto) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Book b = new Book();
        b.setIsbn(dto.isbn);
        b.setName(dto.name);
        b.setAuthor(dto.author);
        try {
            b.setDate(fmt.parse(dto.date));
        } catch (Exception ignore) {
            b.setDate(new Date());
        }
        b.setEditor(dto.editor);
        b.setPages(dto.pages);
        b = bookRepository.save(b);
        return b;
    }
}
