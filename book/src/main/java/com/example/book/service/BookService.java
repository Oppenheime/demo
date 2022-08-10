package com.example.book.service;

import com.example.book.domain.Book;
import com.example.book.mapper.BookMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Integer id);

    int saveBook(Book book);

    int updateBook(Book book);

    int deleteBook(Integer id);
}
