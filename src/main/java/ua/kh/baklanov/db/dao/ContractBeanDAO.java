package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.bean.ContractBean;

import java.util.List;

public interface ContractBeanDAO extends DAOGetAll<ContractBean> {
    List<ContractBean> getContractBeansByUserId(long userId) throws DbException;
}
