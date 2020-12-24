package com.ruida.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 1.普通的属性注入(构造方法注入)
 * 2.类型安全的属性注入(set方法注入)
 * @author: chenjy
 * @create: 2020-10-29 11:05
 */
@Component
@PropertySource("classpath:config/book.properties")
@ConfigurationProperties(prefix = "book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    //@Value("${book.id}")
    private Long id;

    //@Value("${book.name}")
    private String name;

    //@Value("${book.author}")
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
