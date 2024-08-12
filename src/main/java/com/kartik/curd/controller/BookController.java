package com.kartik.curd.controller;

import com.kartik.curd.entity.ResponseModel;
import com.kartik.curd.entity.book.Book;
import com.kartik.curd.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
//@Transactional
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
    public Book getBookById(@PathVariable Long id) throws InterruptedException {

//        return bookRepository.getById(1l);
        return getMethod();
    }

    @Transactional(propagation = Propagation.NESTED, rollbackFor = CustomException.class)
    private Book getMethod() {
        Optional<Book> byId = bookRepository.findById(1L);
        if (byId.isEmpty()) {
            Book book = new Book();
            book.setBookName("test");
            book.setPage(1L);
            bookRepository.save(book);
        }

        return getMethod1(byId.get());

    }

    private Book getMethod1(Book book) {

        return getMethod2(book);
    }

    private Book getMethod2(Book book) {

        return getMethod3(book);
    }

    private Book getMethod3(Book book) {

        book.setPage(book.getPage() + 1);
        bookRepository.save(book);
        return getMethod4(book);
    }

    private Book getMethod4(Book book) {
        return getMethod5(book);
    }

    private Book getMethod5(Book book) {

        book.setPage(book.getPage() + 1);
//        book.setBookName(book.getBookName() + book.getPage());
        bookRepository.save(book);
        if (true)
        throw new CustomException();

        return book;
    }

}
