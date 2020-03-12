package ua.kh.baklanov.service;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.db.mysql.repository.MySQLUserDAOImpl;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;

public class MySQLService implements DAOService {
    private static final Logger LOG = Logger.getLogger(MySQLUserDAOImpl.class);

    public UserDAO getUserDao() throws DbException {
        try {
            return new MySQLUserDAOImpl();
        } catch (DbException e) {
            LOG.error(Messages.ERROR_CREATING_DAO_IN_SERVICE+MySQLUserDAOImpl.class.getName(),e);
            throw new DbException(Messages.ERROR_CREATING_DAO_IN_SERVICE+MySQLUserDAOImpl.class.getName(),e);
        }
    }
}
