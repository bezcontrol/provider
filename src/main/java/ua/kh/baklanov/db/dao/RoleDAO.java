package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.Role;

public interface RoleDAO extends DAOGetAll<Role>{
    Role getRoleByName(String name) throws DbException;
}
