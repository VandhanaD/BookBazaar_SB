package com.book.BookBazaar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookBazaarService {
    @Autowired
    BookBazaarRepository bookBazaarRepository;
    List<Book> bookList = new ArrayList<>();

    public List<Book> getBookData()
    {
       bookList = bookBazaarRepository.getBookData();
       return bookList;
    }


    public List<Book> prepareBookData() {

            Book book = new Book();
            book.setId(1);
            book.setTitle("Java Concurrency in Practice");
            book.setAuthor("Brain Goetz");
            book.setProductId(123);
            book.setRatings(15);
            book.setReviews(11);
            book.setPrice(900);
            bookList.add(book);

        return bookList;
    }
}
