package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import com.example.service.AutoBookService;
import com.example.controller.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    AutoBookService bookService;

    @PostMapping
    public R save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new R(flag,flag?"添加成功":"添加失败");
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
    public R update(@RequestBody Book book) throws Exception {
        boolean flag = bookService.updateById(book);
        return new R(flag,flag?"修改成功":"修改失败");
    }

    @GetMapping("{id}")
    public R getOne(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping("{current}/{size}")
    public R getPage(@PathVariable Integer current,@PathVariable Integer size,Book book){
//        IPage page = new Page(current,size);
//        bookService.page(page);
//        if (current > page.getPages()){
//            page = new Page(page.getPages(),size);
//            page = bookService.page(page);
//        }
//        return new R(null != page,page);

        IPage page = bookService.getPage(current,size,book);
        if (current > page.getPages()){
            page = bookService.getPage((int) page.getPages(),size,book);
        }
        return new R(null != page,page);
    }
}
