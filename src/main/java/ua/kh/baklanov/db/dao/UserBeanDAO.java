package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.bean.UserBean;

public interface UserBeanDAO extends DAOGetAll<UserBean> {
    UserBean getByLogin(String login) throws DbException;

    UserBean getByEmail(String email) throws DbException;
}
