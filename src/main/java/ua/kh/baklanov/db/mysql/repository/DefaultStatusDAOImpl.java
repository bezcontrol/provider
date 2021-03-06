package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.StatusDAO;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultStatusDAOImpl implements StatusDAO {
    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultStatusDAOImpl.class);

    public DefaultStatusDAOImpl() {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public Status getStatusByName(String name) throws DbException {
        LOG.info(Messages.INFO_GET_BY_NAME+ Status.class.getSimpleName());
        Status status=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_STATUS_BY_NAME)) {
            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    status = DefaultExtractorUtil.extractStatus(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_BY_NAME+Status.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_NAME+Status.class.getSimpleName(), ex);
        }
        return status;
    }

    @Override
    public List<Status> getAll() throws DbException {
        List<Status> allStatuses=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_STATUSES)) {
                while (rs.next()) {
                    allStatuses.add(DefaultExtractorUtil.extractStatus(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS +Status.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS +Status.class.getSimpleName(), ex);
        }
        return allStatuses;
    }
}
