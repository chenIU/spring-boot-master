package com.ruida.springbootdemo.mapper;

import com.ruida.springbootdemo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * PersonMapper继承基类
 */
@Mapper
@Repository
public interface PersonMapper extends MyBatisBaseDao<Person, Person> {
}