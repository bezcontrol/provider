package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.db.mysql.DefaultFactory;
import ua.kh.baklanov.exception.DbException;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAOFactory {

    Connection getConnection() throws DbException;

    static DefaultFactory getMySQLDAOFactory() throws DbException {
       return DefaultFactory.getInstance();
    }

    static void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {

            }
        }
    }

    static void commit(Connection con) {
        if (con != null) {
            try {
                con.commit();
            } catch (SQLException ex) {

            }
        }
    }
}
