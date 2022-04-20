package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

public interface AutoBookService extends IService<Book> {
    IPage<Book> getPage(Integer currentPage, Integer size);
    IPage<Book> getPage(Integer currentPage, Integer size, Book book);
}
