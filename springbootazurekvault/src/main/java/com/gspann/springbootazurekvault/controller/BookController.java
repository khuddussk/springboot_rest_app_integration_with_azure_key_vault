package com.gspann.springbootazurekvault.controller;

import com.gspann.springbootazurekvault.model.Book;
import com.gspann.springbootazurekvault.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;
	@Value("${welcome.message}")
	private String welcomeMessage;

	@GetMapping("/welcome")
	public String retrieveWelcomeMessage() {
		// Complex Method
		return welcomeMessage;
	}

    @GetMapping()
    public ResponseEntity<List<Book>> getListOfAllBooks() {

        return bookService.getListOfAllBooks();
    }



    @PostMapping()
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {

        return bookService.createBooks(book);
    }

    @PutMapping("/{id}")
    public Optional<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBookById( @PathVariable("id") long id) {
        return bookService.deleteBookById(id);

    }
    @GetMapping("/{id}")
    public Optional<Book> getBookById( @PathVariable long id) {
        System.out.println("id>>>>>>>>>>" + id);
        return bookService.getBookById(id);
    }
}
