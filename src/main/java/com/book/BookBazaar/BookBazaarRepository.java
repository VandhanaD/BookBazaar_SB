package com.book.BookBazaar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookBazaarRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    String query;

    public List<Book> getBookData()
    {
        query = "select * from BookData";
        List<Book> bookList = jdbcTemplate.query(query, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book b = new Book();
                b.setId(resultSet.getInt("id"));
                b.setTitle(resultSet.getString("title"));
                b.setAuthor(resultSet.getString("author"));
                b.setProductId(resultSet.getInt("productId"));
                b.setRatings(resultSet.getInt("ratings"));
                b.setReviews(resultSet.getInt("reviews"));
                b.setPrice(resultSet.getInt("price"));
                return b;
            }
        });
        return bookList;
    }
}
