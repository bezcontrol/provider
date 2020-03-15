package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;

import java.util.List;

public interface TVDAO extends DAOGetAll {
    List<String> getTypes() throws DbException;
}
