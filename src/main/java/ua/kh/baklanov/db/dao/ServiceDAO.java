package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.Service;

public interface ServiceDAO extends DAO<Service>{
    Service getServiceByTariffId(long id) throws DbException;

    Service getTVServiceByIdAndInternetId(long id, long internetId) throws DbException;

    Service getPCServiceByIdAndInternetId(long id, long internetId) throws DbException;

    Service getMobileServiceByIdAndInternetId(long id, long internetId) throws DbException;

    Service getTVServiceByIdAndWithoutInternet(long id) throws DbException;

    Service getPCServiceByIdAndWithoutInternet(long id) throws DbException;

    Service getMobileServiceByIdAndWithoutInternet(long id) throws DbException;
}
