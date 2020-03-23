package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.AnyServiceDAO;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultAnyServiceDAOImpl implements AnyServiceDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultAnyServiceDAOImpl.class);

    public DefaultAnyServiceDAOImpl() {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public void insert(AnyService obj) throws DbException {

    }

    @Override
    public AnyService getById(long id) throws DbException {
        return null;
    }

    @Override
    public void update(AnyService obj) throws DbException {

    }

    @Override
    public void delete(AnyService obj) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        List<AnyService> typedServices = new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_ANY_SERVICES)) {
                while (rs.next()) {
                    if (rs.getLong("idPC") != 0) {
                        typedServices.add(DefaultExtractorUtil.extractAnyServicePC(rs));
                    } else if (rs.getLong("idTV") != 0) {
                        typedServices.add(DefaultExtractorUtil.extractAnyServiceTV(rs));
                    } else {
                        typedServices.add(DefaultExtractorUtil.extractAnyServiceMobile(rs));
                    }
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_PART_OF_RECORDS + AnyService.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_PART_OF_RECORDS + AnyService.class.getSimpleName(), ex);
        }
        return typedServices;
    }

    @Override
    public List<AnyService> getCurrentPCTypedServices(long idPC) throws DbException {
        List<AnyService> typedServices = new ArrayList<>();
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_ANY_SERVICES_OF_PC)) {
            statement.setLong(1, idPC);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    typedServices.add(DefaultExtractorUtil.extractAnyServicePC(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_PART_OF_RECORDS + AnyService.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_PART_OF_RECORDS + AnyService.class.getSimpleName(), ex);
        }
        return typedServices;
    }

    @Override
    public List<AnyService> getCurrentTVTypedServices(long idTV) throws DbException {
        List<AnyService> typedServices = new ArrayList<>();
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_ANY_SERVICES_OF_TV)) {
            statement.setLong(1, idTV);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    typedServices.add(DefaultExtractorUtil.extractAnyServiceTV(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_PART_OF_RECORDS + AnyService.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_PART_OF_RECORDS + AnyService.class.getSimpleName(), ex);
        }
        return typedServices;
    }

    @Override
    public List<AnyService> getCurrentMobileTypedServices(long idMobile) throws DbException {
        List<AnyService> typedServices = new ArrayList<>();
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_ANY_SERVICES_OF_MOBILE)) {
            statement.setLong(1, idMobile);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    typedServices.add(DefaultExtractorUtil.extractAnyServiceMobile(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_PART_OF_RECORDS + AnyService.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_PART_OF_RECORDS + AnyService.class.getSimpleName(), ex);
        }
        return typedServices;
    }
}
