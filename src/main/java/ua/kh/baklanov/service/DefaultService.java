package ua.kh.baklanov.service;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DaoGetAll;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.db.mysql.repository.DefaultTVDaoImpl;
import ua.kh.baklanov.db.mysql.repository.DefaultUserDAOImpl;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;

public class DefaultService implements DAOService {
    private static final Logger LOG = Logger.getLogger(DefaultService.class);

    public UserDAO getUserDao() throws DbException {
        try {
            return new DefaultUserDAOImpl();
        } catch (DbException e) {
            LOG.error(Messages.ERROR_CREATING_DAO + DefaultUserDAOImpl.class.getName(),e);
            throw new DbException(Messages.ERROR_CREATING_DAO + DefaultUserDAOImpl.class.getName(),e);
        }
    }

    public DaoGetAll getTVDao() throws DbException {
        try {
            return new DefaultTVDaoImpl();
        } catch (DbException e) {
            LOG.error(Messages.ERROR_CREATING_DAO + DefaultTVDaoImpl.class.getName(),e);
            throw new DbException(Messages.ERROR_CREATING_DAO + DefaultTVDaoImpl.class.getName(),e);
        }
    }
}
