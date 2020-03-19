package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.Service;

public interface ServiceDAO extends DAO<Service>{
    Service getServiceByTariffId(long id) throws DbException;
}
