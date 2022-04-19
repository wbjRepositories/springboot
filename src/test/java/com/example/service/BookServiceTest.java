package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("测试数据2222");
        book.setType("测试数据2222");
        book.setDescription("测试数据2222");
        bookService.save(book);
    }

    @Test
    public void testDelete(){
        bookService.delete(15);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(14);
        book.setName("测试数据2222");
        book.setType("测试数据2222");
        book.setDescription("测试数据2222");
        System.out.println(bookService.update(book));
    }

    @Test
    public void testGetById(){
        System.out.println(bookService.getById(3));
    }

    @Test
    public void testGetAll(){
        List<Book> all = bookService.getAll();
        System.out.println(all);
    }

    @Test
    public void testGetPage(){
        IPage<Book> page = bookService.getPage(1, 5);
        System.out.println(page);
    }

}
