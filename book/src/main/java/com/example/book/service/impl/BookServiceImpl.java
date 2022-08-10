package com.example.book.service.impl;

import com.example.book.domain.Book;
import com.example.book.mapper.BookMapper;
import com.example.book.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
  @Autowired
  private BookMapper bookMapper;

  public List<Book> findAll(){
    return bookMapper.findAll();
  }

  @Override
  public Book findById(Integer id) {
    return bookMapper.findById(id);
  }

  @Override
  public int saveBook(Book book) {
    return bookMapper.saveBook(book);
  }

  @Override
  public int updateBook(Book book) {
    return bookMapper.updateBook(book);
  }

  @Override
  public int deleteBook(Integer id) {
    return bookMapper.deleteBook(id);
  }
}
