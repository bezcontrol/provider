package ua.kh.baklanov.service;

import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;

public interface DAOService {
    UserDAO getUserDao() throws DbException;
    TVDAO getTVDao() throws DbException;
    AnyTariffDAO getTariffDao() throws DbException;
}
