package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.bean.AnyService;

import java.util.List;


public interface AnyServiceDAO extends DAO<AnyService> {
    List<AnyService> getCurrentPCTypedServices(long idPC) throws DbException;
    List<AnyService> getCurrentTVTypedServices(long idTV) throws DbException;
    List<AnyService> getCurrentMobileTypedServices(long idMobile) throws DbException;
}
