package com.kartik.curd.entity.book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/*
 *
 * this is parent entity
 * so, this class manage the association
 * so helper function added in this class
 *
 * */


@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    public Book() {
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(
                    name = "book_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "author_id"
            )
    )
    private Set<Author> authorList = new HashSet<>();


    public void addAuthor(Author author) {
        this.authorList.add(author);
        author.getBookList().add(this);
    }

    public void removeAuthor(Author author) {
        this.authorList.remove(author);
        author.getBookList().remove(this);
    }


    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Set<Author> getAuthorList() {
        return authorList;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Book)) return false;
//
//        Book book = (Book) o;
//
//        if (id != null ? !id.equals(book.id) : book.id != null) return false;
//        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
//        return authorList != null ? authorList.equals(book.authorList) : book.authorList == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
//        result = 31 * result + (authorList != null ? authorList.hashCode() : 0);
//        return result;
//    }
}
