package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.context.Attributes;
import ua.kh.baklanov.context.Context;
import ua.kh.baklanov.db.mysql.DefaultFactory;
import ua.kh.baklanov.exception.DbException;

import java.sql.Connection;

public interface DAOFactory {

    Connection getConnection() throws DbException;

    static DefaultFactory getDefaultFactory() {
       return (DefaultFactory) Context.get(Attributes.DB_FACTORY);
    }

    void commit(Connection connection) throws DbException;

    void rollback(Connection connection) throws DbException;

}
