package com.gspann.springbootazurekvault.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String isbn;

    @NotNull
    private String bookName;
    @NotNull
    private String author;
    @NotNull
    private Integer copies;


    public Book(String isbn, String bookName, String author, Integer copies) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.copies = copies;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", copies=" + copies +
                '}';
    }
}
