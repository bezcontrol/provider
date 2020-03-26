package ua.kh.baklanov.service;

import ua.kh.baklanov.db.dao.*;
import ua.kh.baklanov.exception.DbException;

public interface DAOService {
    UserDAO getUserDAO() throws DbException;
    UserBeanDAO getUserBeanDAO() throws DbException;
    TVDAO getTVDAO() throws DbException;
    PCDAO getPCDAO() throws DbException;
    AnyTariffDAO getAnyTariffDAO() throws DbException;
    AnyServiceDAO getAnyServiceDAO() throws DbException;
    ServiceDAO getServiceDAO() throws DbException;
    TariffDAO getTariffDAO() throws DbException;
    InternetDAO getInternetDAO() throws DbException;
    MobileDAO getMobileDAO() throws DbException;
    RoleDAO getRoleDAO() throws DbException;
    StatusDAO getStatusDAO() throws DbException;
}
