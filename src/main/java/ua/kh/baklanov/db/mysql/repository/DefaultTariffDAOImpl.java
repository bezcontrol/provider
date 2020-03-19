package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.Tariff;

import java.util.List;

public class DefaultTariffDAOImpl implements TariffDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultTariffDAOImpl.class);


    public DefaultTariffDAOImpl() {
            factory = DAOFactory.getDefaultFactory();
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
