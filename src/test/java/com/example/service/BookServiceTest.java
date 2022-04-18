package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testSave(){

    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testUpdate(){

    }

    @Test
    public void testGetById(){
        System.out.println(bookService.getById(3));
    }

    @Test
    public void testGetAll(){

    }

    @Test
    public void testGetPage(){

    }

}
