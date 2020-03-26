package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.Status;

public interface StatusDAO extends DAOGetAll<Status> {
    Status getStatusByName(String name) throws DbException;
}
