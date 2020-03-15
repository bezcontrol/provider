package ua.kh.baklanov.service;

import ua.kh.baklanov.db.dao.DAOGetAll;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;

public interface DAOService {
    UserDAO getUserDao() throws DbException;
    DAOGetAll getTVDao() throws DbException;
}
