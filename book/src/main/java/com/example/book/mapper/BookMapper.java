package com.example.book.mapper;

import com.example.book.domain.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    List<Book> findAll();

    Book findById(@Param("id") Integer id);

    int saveBook(Book book);

    int updateBook(Book book);

    int deleteBook(@Param("id") Integer id);
}
