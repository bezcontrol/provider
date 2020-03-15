package ua.kh.baklanov.service;

import ua.kh.baklanov.db.dao.DaoGetAll;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;

public interface DAOService {
    UserDAO getUserDao() throws DbException;
    DaoGetAll getTVDao() throws DbException;
}
