package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.TV;

import java.util.List;

public interface TVDAO extends DAO<TV> {
    List<String> getTypes() throws DbException;
}
