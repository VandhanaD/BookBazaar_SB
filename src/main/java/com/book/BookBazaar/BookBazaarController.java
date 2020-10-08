package com.book.BookBazaar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class BookBazaarController {
    @Autowired
    BookBazaarService b;

    @RequestMapping(value = "/book/", method = RequestMethod.GET )

    public ResponseEntity getBookData()
    {
        ResponseEntity r;
        List<Book> bookDataList =  new ArrayList<>();
        //bookDataList = b.prepareBookData();

        bookDataList = b.getBookData();
        Map map = new HashMap<>();
        map.put("id",bookDataList.get(0).getId());
        map.put("title",bookDataList.get(0).getTitle());
        map.put("author",bookDataList.get(0).getAuthor());
        map.put("productId",bookDataList.get(0).getProductId());
        map.put("ratings",bookDataList.get(0).getRatings());
        map.put("reviews", bookDataList.get(0).getReviews());
        map.put("price",bookDataList.get(0).getPrice());

        r = new ResponseEntity(map, HttpStatus.OK);
        return r;
    }
}
