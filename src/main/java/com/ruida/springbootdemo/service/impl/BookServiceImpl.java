package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.entity.Book;
import com.ruida.springbootdemo.mapper.BookMapper;
import com.ruida.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> listBooks() {
        return bookMapper.selectList(null);
    }
}
