package com.ruida.springbootdemo.controller.book;

import com.ruida.springbootdemo.entity.result.ListResult;
import com.ruida.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("list")
    public ListResult list(){
        ListResult result = new ListResult();
        result.setContent(bookService.listBooks());
        return result;
    }
}
