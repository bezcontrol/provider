package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.bean.AnyTariff;

import java.util.List;

public interface AnyTariffDAO extends DAO<AnyTariff>{
    List<AnyTariff> getAllMobileTariffs() throws DbException;

    List<AnyTariff> getAllPCTariffs()throws DbException;

    List<AnyTariff> getAllTVTariffs()throws DbException;

    List<AnyTariff> getTVTariffsOfCurrentType(String type)throws DbException;
}
