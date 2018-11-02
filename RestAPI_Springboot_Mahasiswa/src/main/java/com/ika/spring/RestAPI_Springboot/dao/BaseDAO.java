package com.ika.spring.RestAPI_Springboot.dao;

import java.util.List;

public interface BaseDAO<T> {

    T save(T param);

    T update(T param);

    int delete(T param);

    List<T> find();

    T findById(int id);

}