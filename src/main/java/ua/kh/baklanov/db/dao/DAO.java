package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;

public interface DAO<T> extends DAOGetAll {
    void insert(T obj)throws DbException;
    T getById(long id) throws DbException;
    void update(T obj) throws DbException;
    void delete(T obj) throws DbException;
}
