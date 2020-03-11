package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.User;

public interface UserDAO extends DAO {
    User getByLogin(String login) throws DbException;
}
