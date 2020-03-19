package ua.kh.baklanov.db.mysql;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public final class DefaultFactory implements DAOFactory {

    private static final Logger LOG = Logger.getLogger(DefaultFactory.class);

    private static DefaultFactory instance;
    private DataSource ds;

    private DefaultFactory() throws DbException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            LOG.info(Messages.INFO_CONTEXT_INITIALIZED);
            ds = (DataSource) envContext.lookup("jdbc/internet_provider");
            LOG.info(Messages.INFO_DATASOURCE_INITIALIZED);
        } catch (NamingException ex) {
            LOG.error(Messages.ERROR_CONTEXT_CREATING_FACTORY, ex);
            throw new DbException(Messages.ERROR_CONTEXT_CREATING_FACTORY, ex);
        }
    }

    public static synchronized DefaultFactory getInstance() throws DbException {
        LOG.info(Messages.INFO_GET_FACTORY);
        if(instance==null){
            LOG.info(Messages.INFO_FACTORY_INIT);
            instance=new DefaultFactory();
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
        LOG.info(Messages.INFO_CONNECTION_OBTAINED);
        return con;
    }


    public void rollback(Connection con) throws DbException {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                LOG.error(Messages.ERROR_ROLLBACK_TRANSACTION, ex);
                throw new DbException(Messages.ERROR_ROLLBACK_TRANSACTION, ex);
            }
        }
    }

    public void commit(Connection con) throws DbException {
        if (con != null) {
            try {
                con.commit();
            } catch (SQLException ex) {
                LOG.error(Messages.ERROR_COMMIT_TRANSACTION, ex);
                throw new DbException(Messages.ERROR_COMMIT_TRANSACTION, ex);
            }
        }
    }
}
