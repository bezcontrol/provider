package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.InternetDAO;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Internet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DefaultInternetDAOImpl implements InternetDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultInternetDAOImpl.class);

    public DefaultInternetDAOImpl()  {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public void insert(Internet obj) throws DbException {

    }

    @Override
    public Internet getById(long id) throws DbException {
        LOG.info(Messages.INFO_GET_BY_ID+Internet.class.getSimpleName());
        Internet internet=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_INTERNET_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    internet = DefaultExtractorUtil.extractInternet(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_BY_ID+Internet.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_ID+Internet.class.getSimpleName(), ex);
        }
        return internet;
    }

    @Override
    public void update(Internet obj) throws DbException {

    }

    @Override
    public void delete(Internet obj) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        return null;
    }
}
