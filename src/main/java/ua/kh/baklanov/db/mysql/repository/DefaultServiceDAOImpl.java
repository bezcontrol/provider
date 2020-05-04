package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;

import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.ServiceDAO;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void delete(long id) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        return new ArrayList();
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

    @Override
    public Service getTVServiceByIdAndInternetId(long id, long internetId) throws DbException {
        Service service=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_TV_SERVICES_BY_ID)) {
            statement.setLong(1, id);
            statement.setLong(2, internetId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    service = DefaultExtractorUtil.extractService(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_SERVICE_BY_ID, ex);
            throw new DbException(Messages.ERROR_GET_SERVICE_BY_ID, ex);
        }
        return service;
    }

    @Override
    public Service getPCServiceByIdAndInternetId(long id, long internetId) throws DbException {
        Service service=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_PC_SERVICES_BY_ID)) {
            statement.setLong(1, id);
            statement.setLong(2, internetId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    service = DefaultExtractorUtil.extractService(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_SERVICE_BY_ID, ex);
            throw new DbException(Messages.ERROR_GET_SERVICE_BY_ID, ex);
        }
        return service;
    }

    @Override
    public Service getMobileServiceByIdAndInternetId(long id, long internetId) throws DbException {
        Service service=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_MOBILE_SERVICES_BY_ID)) {
            statement.setLong(1, id);
            statement.setLong(2, internetId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    service = DefaultExtractorUtil.extractService(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_SERVICE_BY_ID, ex);
            throw new DbException(Messages.ERROR_GET_SERVICE_BY_ID, ex);
        }
        return service;
    }

    @Override
    public Service getTVServiceByIdAndWithoutInternet(long id) throws DbException {
        Service service=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_TV_SERVICES_BY_ID_WITHOUT_INTERNET)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    service = DefaultExtractorUtil.extractService(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_SERVICE_BY_ID, ex);
            throw new DbException(Messages.ERROR_GET_SERVICE_BY_ID, ex);
        }
        return service;
    }

    @Override
    public Service getPCServiceByIdAndWithoutInternet(long id) throws DbException {
        Service service=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_PC_SERVICES_BY_ID_WITHOUT_INTERNET)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    service = DefaultExtractorUtil.extractService(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_SERVICE_BY_ID, ex);
            throw new DbException(Messages.ERROR_GET_SERVICE_BY_ID, ex);
        }
        return service;
    }

    @Override
    public Service getMobileServiceByIdAndWithoutInternet(long id) throws DbException {
        Service service=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_MOBILE_SERVICES_BY_ID_WITHOUT_INTERNET)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    service = DefaultExtractorUtil.extractService(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_SERVICE_BY_ID, ex);
            throw new DbException(Messages.ERROR_GET_SERVICE_BY_ID, ex);
        }
        return service;
    }
}
