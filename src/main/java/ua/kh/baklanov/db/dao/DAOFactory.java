package ua.kh.baklanov.db.dao;

import ua.kh.baklanov.db.mysql.MySQLFactory;
import ua.kh.baklanov.exception.DbException;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAOFactory {

    Connection getConnection() throws DbException;

    UserDAO getUserDAO() throws DbException;

    static MySQLFactory getMySQLDAOFactory() throws DbException {
       return MySQLFactory.getInstance();
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
