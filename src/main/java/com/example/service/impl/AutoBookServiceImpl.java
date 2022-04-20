package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.BookDao;
import com.example.domain.Book;
import com.example.service.AutoBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoBookServiceImpl extends ServiceImpl<BookDao, Book> implements AutoBookService {
    @Autowired
    BookDao dao;

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer size, Book book) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        wrapper.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        wrapper.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        IPage page = new Page(currentPage,size);
        dao.selectPage(page,wrapper);
        return page;
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer size) {
        IPage page = new Page(currentPage,size);
        dao.selectPage(page,null);
        return page;
    }
}
