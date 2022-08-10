package com.example.book.controller;

import com.example.book.domain.Book;
import com.example.book.service.BookService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;
    /**
     * 查找全部书籍(带分页)
     */

    @GetMapping(value = "/findAll")
    public List<Book> findAll(@RequestParam Integer page, @RequestParam Integer size) {
        PageHelper.startPage(page,size);
        return bookService.findAll();
    }

    /**
     * 新增书籍
     *
     */
    @PostMapping(value = "/saveBook")
    public int saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    /**
     * 查询书籍
     *
     */
    @GetMapping(value = "/findById/{id}")
    public Book findById(@PathVariable("id") String id) {
        Book result = bookService.findById(Integer.parseInt(id));
        if (null != result) {
          return result;
        }
        return null;
    }

    /**
     * 修改书籍
     *
     */
    @PutMapping(value = "/update")
    public int update(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    /**
     * 删除书籍书籍
     *
     */
    @DeleteMapping(value = "/delete/{id}")
    public int delete(@PathVariable("id") String id) {
        return bookService.deleteBook(Integer.parseInt(id));
    }

}
