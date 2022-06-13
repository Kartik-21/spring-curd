package com.kartik.curd.controller;

import com.kartik.curd.entity.ResponseModel;
import com.kartik.curd.entity.book.Book;
import com.kartik.curd.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    private BookRepository bookRepository;


    @PostMapping
    ResponseModel<Book> addBook(@RequestBody Book book) {
        return new ResponseModel<Book>(bookRepository.save(book), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseModel<Book> updateBook(@RequestBody Book book, @PathVariable Long id) {
        return new ResponseModel<Book>(bookRepository.save(book), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseModel<Book> getBookById(@PathVariable Long id) {
        return new ResponseModel<Book>(bookRepository.findById(id).get(), HttpStatus.CREATED);
    }


}
