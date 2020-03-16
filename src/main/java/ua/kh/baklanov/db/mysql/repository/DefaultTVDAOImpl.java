package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.db.mysql.DefaultFactory;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.TV;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultTVDAOImpl implements TVDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultUserDAOImpl.class);

    public DefaultTVDAOImpl() throws DbException {
        try {
            factory = DAOFactory.getMySQLDAOFactory();
        } catch (DbException ex) {
            LOG.error(Messages.ERROR_CREATING_FACTORY+ DefaultFactory.class.getName(), ex);
            throw new DbException(Messages.ERROR_CREATING_FACTORY+ DefaultFactory.class.getName(), ex);
        }
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
}
