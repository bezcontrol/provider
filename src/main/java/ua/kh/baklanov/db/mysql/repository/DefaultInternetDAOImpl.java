package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.InternetDAO;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Internet;
import ua.kh.baklanov.model.entity.Mobile;
import ua.kh.baklanov.model.entity.PC;
import ua.kh.baklanov.model.entity.TV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultInternetDAOImpl implements InternetDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultInternetDAOImpl.class);

    public DefaultInternetDAOImpl() {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public void insert(Internet obj) throws DbException {

    }

    @Override
    public Internet getById(long id) throws DbException {
        LOG.info(Messages.INFO_GET_BY_ID + Internet.class.getSimpleName());
        Internet internet = null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_INTERNET_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    internet = DefaultExtractorUtil.extractInternet(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_BY_ID + Internet.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_ID + Internet.class.getSimpleName(), ex);
        }
        return internet;
    }

    @Override
    public void update(Internet obj) throws DbException {

    }

    @Override
    public void delete(long id) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        LOG.info(Messages.INFO_GET_ALL_RECORDS + Internet.class.getSimpleName());
        List<Internet> allInternet = new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_INTERNET)) {
                while (rs.next()) {
                    allInternet.add(DefaultExtractorUtil.extractInternet(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS + Internet.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS + Internet.class.getSimpleName(), ex);
        }
        return allInternet;
    }

    @Override
    public List<Internet> getPCList(long idPC) throws DbException {
        LOG.info(Messages.INFO_GET_INTERNET_TYPED_RECORDS + PC.class.getSimpleName());
        List<Internet> typedInternet = new ArrayList<>();
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_PC_INTERNET)) {
            statement.setLong(1, idPC);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    typedInternet.add(DefaultExtractorUtil.extractInternet(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_PART_OF_RECORDS + Internet.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_PART_OF_RECORDS + Internet.class.getSimpleName(), ex);
        }
        return typedInternet;
    }

    @Override
    public List<Internet> getTVList(long idTV) throws DbException {
        LOG.info(Messages.INFO_GET_INTERNET_TYPED_RECORDS + TV.class.getSimpleName());
        List<Internet> typedInternet = new ArrayList<>();
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_TV_INTERNET)) {
            statement.setLong(1, idTV);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    typedInternet.add(DefaultExtractorUtil.extractInternet(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_PART_OF_RECORDS + Internet.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_PART_OF_RECORDS + Internet.class.getSimpleName(), ex);
        }
        return typedInternet;
    }

    @Override
    public List<Internet> getMobileList(long idMobile) throws DbException {
        LOG.info(Messages.INFO_GET_INTERNET_TYPED_RECORDS + Mobile.class.getSimpleName());
        List<Internet> typedInternet = new ArrayList<>();
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_MOBILE_INTERNET)) {
            statement.setLong(1, idMobile);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    typedInternet.add(DefaultExtractorUtil.extractInternet(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_PART_OF_RECORDS + Internet.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_PART_OF_RECORDS + Internet.class.getSimpleName(), ex);
        }
        return typedInternet;
    }
}
