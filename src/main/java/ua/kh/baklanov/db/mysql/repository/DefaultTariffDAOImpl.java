package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.db.mysql.DefaultFactory;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.TV;
import ua.kh.baklanov.model.entity.Tariff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultTariffDAOImpl implements TariffDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultTariffDAOImpl.class);


    public DefaultTariffDAOImpl() throws DbException {
        try {
            factory = DAOFactory.getMySQLDAOFactory();
        } catch (DbException ex) {
            LOG.error(Messages.ERROR_CREATING_FACTORY+ DefaultFactory.class.getName(), ex);
            throw new DbException(Messages.ERROR_CREATING_FACTORY+ DefaultFactory.class.getName(), ex);
        }
    }

    @Override
    public void insert(Tariff obj) throws DbException {

    }

    @Override
    public Tariff getById(long id) throws DbException {
        return null;
    }

    @Override
    public void update(Tariff obj) throws DbException {

    }

    @Override
    public void delete(Tariff obj) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        return null;
    }
}
