package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.BookDao;
import com.example.domain.Book;
import com.example.service.AutoBookService;
import org.springframework.stereotype.Service;

@Service
public class AutoBookServiceImpl extends ServiceImpl<BookDao, Book> implements AutoBookService {

}
