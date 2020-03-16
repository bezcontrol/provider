package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.Tariff;

import java.util.List;

public interface TariffDAO extends DAO<Tariff> {
    List<Tariff> getAllTariffsOfServiceType() throws DbException;
}
