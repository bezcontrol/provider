package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.bean.AnyService;

import java.util.List;
/**
 * @author      Aleksei Baklanov
 * */
public interface AnyServiceDAO extends DAOGetAll<AnyService> {
    /**
     * @param idPC - id of PC that contains in services
     */
    List<AnyService> getCurrentPCTypedServices(long idPC) throws DbException;
    /**
     * @param idTV - id of TV that contains in services
     */
    List<AnyService> getCurrentTVTypedServices(long idTV) throws DbException;
    /**
     * @param idMobile - id of Mobile that contains in services
     */
    List<AnyService> getCurrentMobileTypedServices(long idMobile) throws DbException;
}
