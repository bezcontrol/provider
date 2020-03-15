package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;

import java.util.List;

public interface DAOGetAll<T> {
    List<T> getAll() throws DbException;
}
