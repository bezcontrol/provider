package ua.kh.baklanov.service;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.db.mysql.repository.DefaultTVDAOImpl;
import ua.kh.baklanov.db.mysql.repository.DefaultAnyTariffDAOImpl;
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

    public TVDAO getTVDao() throws DbException {
        try {
            return new DefaultTVDAOImpl();
        } catch (DbException e) {
            LOG.error(Messages.ERROR_CREATING_DAO + DefaultTVDAOImpl.class.getName(),e);
            throw new DbException(Messages.ERROR_CREATING_DAO + DefaultTVDAOImpl.class.getName(),e);
        }
    }

    @Override
    public AnyTariffDAO getTariffDao() throws DbException {
        try {
            return new DefaultAnyTariffDAOImpl();
        } catch (DbException e) {
            LOG.error(Messages.ERROR_CREATING_DAO + DefaultAnyTariffDAOImpl.class.getName(),e);
            throw new DbException(Messages.ERROR_CREATING_DAO + DefaultAnyTariffDAOImpl.class.getName(),e);
        }
    }
}
