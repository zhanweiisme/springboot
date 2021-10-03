package com.lovezhan.service.impl;

import com.lovezhan.bean.Book;
import com.lovezhan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@CacheConfig
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Cacheable(value = "book", key = "#id")
    @Override
    public Long getBookById(int id) {
        String sql = "select count(1) from book where id=" + id;
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("执行了吗？……");
        return aLong;
    }

}
