package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.ContractState;

public interface ContractStateDAO extends DAOGetAll<ContractState> {
    ContractState getStatusByName(String name) throws DbException;
}
