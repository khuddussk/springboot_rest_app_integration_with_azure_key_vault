package com.gspann.springbootazurekvault.service;

import org.springframework.http.ResponseEntity;

import com.gspann.springbootazurekvault.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    ResponseEntity<Book> createBooks(Book book);


    ResponseEntity<List<Book>> getListOfAllBooks();

    Optional<Book> updateBook(long id,Book book);

    ResponseEntity<Book> deleteBookById(long id);

    Optional<Book> getBookById(long id);
}
