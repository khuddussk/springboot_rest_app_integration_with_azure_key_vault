package com.gspann.springbootazurekvault.service.impl;

import com.gspann.springbootazurekvault.controller.BookController;
import com.gspann.springbootazurekvault.exception.BookNotFoundException;
import com.gspann.springbootazurekvault.model.Book;
import com.gspann.springbootazurekvault.repositry.BookRepository;
import com.gspann.springbootazurekvault.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookRepository bookRepository;


    @Override
    public Optional<Book> getBookById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return Optional.ofNullable(book) ;
    }
    @Override
    public ResponseEntity<List<Book>> getListOfAllBooks() {
        try {
            logger.info("Get  all List of Books ... ");
            List<Book> books = new ArrayList<Book>();
            logger.debug("Get  all List of Books... ");
            bookRepository.findAll().forEach(books::add);
            if (books.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Book> createBooks(Book book) {
        try {
            Book _book = bookRepository.save(new Book(book.getIsbn(), book.getBookName(), book.getAuthor(), book.getCopies()));
            return new ResponseEntity<Book>(_book, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public Optional<Book> updateBook(long id, Book book) {
        Optional<Book> bookData = Optional.ofNullable(bookRepository.findById(id).orElseThrow(BookNotFoundException::new));

        Book existingBook = bookData.get();
        existingBook.setBookName(book.getBookName());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setCopies(book.getCopies());
        bookRepository.save(existingBook);

        return bookData;
    }

    @Override
    public ResponseEntity<Book> deleteBookById(long id) {
        try {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {

            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}


