package ua.kh.baklanov.service;

import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.db.dao.InternetDAO;
import ua.kh.baklanov.db.dao.MobileDAO;
import ua.kh.baklanov.db.dao.PCDAO;
import ua.kh.baklanov.db.dao.ServiceDAO;
import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;

public interface DAOService {
    UserDAO getUserDAO() throws DbException;
    TVDAO getTVDAO() throws DbException;
    PCDAO getPCDAO() throws DbException;
    AnyTariffDAO getAnyTariffDAO() throws DbException;
    ServiceDAO getServiceDAO() throws DbException;
    TariffDAO getTariffDAO() throws DbException;
    InternetDAO getInternetDAO() throws DbException;
    MobileDAO getMobileDAO() throws DbException;
}
