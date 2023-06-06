package com.gspann.springbootazurekvault.exception;


public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book Not Found...!");
    }


}