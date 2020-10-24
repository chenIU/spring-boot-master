package com.ruida.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruida.springbootdemo.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    void select(){
        bookMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void insert(){
        Book book = new Book();
        book.setBookName("老人与海");
        book.setPrice(new BigDecimal("25"));
        bookMapper.insert(book);
    }

    @Test
    void delete(){
        bookMapper.deleteById(1);
    }

    @Test
    void OptimisticLocker(){
        Book book2 = bookMapper.selectById(3);
        book2.setBookName("老人与海2");

        Book book3 = bookMapper.selectById(3);
        book3.setBookName("老人与海3");

        bookMapper.updateById(book3);
        bookMapper.updateById(book2);
    }

    @Test
    void multiSelect(){

        //selectBatchIds
        //bookMapper.selectBatchIds(Arrays.asList(1,2)).forEach(System.out::println);

        //selectByMap map查询条件只能做等值判断
        /*Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        bookMapper.selectByMap(map).forEach(System.out::println);*/

        //selectCount 统计数量
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",1);
        //System.out.println(bookMapper.selectCount(wrapper));

        //selectMaps 将查询结果封装到Map中
        //bookMapper.selectMaps(wrapper).forEach(System.out::println);

        //selectPage 分页查询
        /*Page<Book> page = new Page<>(1,2);
        IPage<Book> result = bookMapper.selectPage(page,null);
        System.out.println(result.getSize());
        System.out.println(result.getTotal());
        result.getRecords().forEach(System.out::println);*/

        //selectObjs
        //bookMapper.selectObjs(null).forEach(System.out::println);

        //selectOne 要保证结果集只会返回一条数据
        System.out.println(bookMapper.selectOne(wrapper));
    }

}