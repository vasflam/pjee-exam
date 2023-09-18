package com.usarb.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Persistable;

import java.util.Date;

@Entity(name="books")
public class Book implements Persistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull
    private String isbn;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters long")
    private String name;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 50, message = "Author must be between 3 and 30 characters long")
    private String author;

    @Column(nullable = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    @Size(min = 3, max = 30, message = "Editor must be between 3 and 30 characters longs")
    private String editor;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Integer pages;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return this.id == null;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
