package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.TV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultTVDAOImpl implements TVDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultTVDAOImpl.class);

    public DefaultTVDAOImpl()  {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public List<TV> getAll() throws DbException {
        List<TV> allTV=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_TV)) {
                while (rs.next()) {
                    allTV.add(DefaultExtractorUtil.extractTV(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_RECORDS +TV.class.getName(), ex);
            throw new DbException(Messages.ERROR_GET_RECORDS +TV.class.getName(), ex);
        }
        return allTV;
    }

    @Override
    public List<String> getTypes() throws DbException {
        List<String> types=new ArrayList<>();
        for (TV tv : getAll()) {
            types.add(tv.getType());
        }
        return types;
    }

    @Override
    public void insert(TV obj) throws DbException {

    }

    @Override
    public TV getById(long id) throws DbException {
        LOG.info(Messages.INFO_GET_BY_ID+TV.class.getSimpleName());
        TV tv=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_TV_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    tv = DefaultExtractorUtil.extractTV(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_BY_ID+TV.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_ID+TV.class.getSimpleName(), ex);
        }
        return tv;
    }

    @Override
    public void update(TV obj) throws DbException {

    }

    @Override
    public void delete(TV obj) throws DbException {

    }
}
