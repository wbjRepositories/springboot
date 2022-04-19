package com.example.controller;

import com.example.domain.Book;
import com.example.service.AutoBookService;
import com.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    AutoBookService bookService;

    @PostMapping
    public R save(@RequestBody Book book){
        return new R(bookService.save(book));
    }

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

}
