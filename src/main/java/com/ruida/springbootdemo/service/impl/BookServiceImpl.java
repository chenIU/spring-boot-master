package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.entity.Book;
import com.ruida.springbootdemo.mapper.BookMapper;
import com.ruida.springbootdemo.service.BookService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> listBooks() {
        return bookMapper.selectList(null);
    }
}
