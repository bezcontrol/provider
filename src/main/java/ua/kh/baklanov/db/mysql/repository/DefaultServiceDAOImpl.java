package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.db.dao.DAO;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.ServiceDAO;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.Service;
import ua.kh.baklanov.model.entity.TV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultServiceDAOImpl implements ServiceDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultServiceDAOImpl.class);


    public DefaultServiceDAOImpl(){
            factory = DAOFactory.getDefaultFactory();
    }



    @Override
    public void insert(Service obj) throws DbException {

    }

    @Override
    public Service getById(long id) throws DbException {
        return null;
    }

    @Override
    public void update(Service obj) throws DbException {

    }

    @Override
    public void delete(Service obj) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        return null;
    }

    @Override
    public Service getServiceByTariffId(long id) throws DbException {
        Service service=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_SERVICE_BY_TARIFF_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    service = DefaultExtractorUtil.extractService(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_SERVICE_BY_TARIFF_ID, ex);
            throw new DbException(Messages.ERROR_GET_SERVICE_BY_TARIFF_ID, ex);
        }
        return service;
    }
}
