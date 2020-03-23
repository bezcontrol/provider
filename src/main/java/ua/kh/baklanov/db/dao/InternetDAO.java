package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.Internet;

import java.util.List;

public interface InternetDAO extends DAO<Internet> {
    List<Internet> getPCList(long idPC) throws DbException;

    List<Internet> getTVList(long idTV) throws DbException;

    List<Internet> getMobileList(long idMobile) throws DbException;
}
