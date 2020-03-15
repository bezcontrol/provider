package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;

import java.util.List;

public interface DAO<T> extends DaoGetAll{
    void insert(T obj)throws DbException;
    T getById(long id) throws DbException;
    void update(T obj) throws DbException;
    void delete(T obj) throws DbException;
}
