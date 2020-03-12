package ua.kh.baklanov.db.mysql;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.db.mysql.repository.MySQLUserDAOImpl;
import ua.kh.baklanov.db.dao.UserDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MySQLFactory implements DAOFactory {

    private static final Logger LOG = Logger.getLogger(MySQLFactory.class);

    private static MySQLFactory instance;
    private DataSource ds;

    private MySQLFactory() throws DbException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            // ST4DB - the name of data source
            ds = (DataSource) envContext.lookup("jdbc/internet_provider");

        } catch (NamingException ex) {
            LOG.error(Messages.ERROR_CONTEXT_CREATING_DB, ex);
            throw new DbException(Messages.ERROR_CONTEXT_CREATING_DB, ex);
        }
    }

    public static synchronized MySQLFactory getInstance() throws DbException {
        if(instance==null){
            instance=new MySQLFactory();
        }
        return instance;
    }

    public Connection getConnection() throws DbException {
        Connection con;
        try {
            con = ds.getConnection();
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_OBTAIN_CONNECTION, ex);
            throw new DbException(Messages.ERROR_OBTAIN_CONNECTION, ex);
        }
        return con;
    }
}
