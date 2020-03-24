package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;

import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultUserDAOImpl implements UserDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultUserDAOImpl.class);

    public DefaultUserDAOImpl() {
            factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public User getByLogin(String login) throws DbException {
        User user=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_USER_BY_LOGIN)) {
            statement.setString(1, login);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = DefaultExtractorUtil.extractUser(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_USER_BY_LOGIN, ex);
            throw new DbException(Messages.ERROR_GET_USER_BY_LOGIN, ex);
        }
        return user;
    }

    @Override
    public User getByEmail(String email) throws DbException {
        User user=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_USER_BY_EMAIL)) {
            statement.setString(1, email);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = DefaultExtractorUtil.extractUser(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_USER_BY_EMAIL, ex);
            throw new DbException(Messages.ERROR_GET_USER_BY_EMAIL, ex);
        }
        return user;
    }

    @Override
    public void insert(User obj) throws DbException {
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.INSERT_USER)) {
            int k=1;
            statement.setString(k, obj.getLogin());
            k++;
            statement.setString(k, obj.getPassword());
            k++;
            statement.setString(k, obj.getEmail());
            k++;
            statement.setLong(k, obj.getIdRole());
            k++;
            statement.setLong(k, obj.getIdStatus());
            k++;
            statement.setDouble(k, obj.getBill());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                LOG.info(Messages.INFO_SUCCESSFULLY_INSERTED+User.class.getSimpleName());
            }
            factory.commit(con);
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_INSERT + User.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_INSERT + User.class.getSimpleName(), ex);
        }
    }

    @Override
    public User getById(long id) throws DbException {
        LOG.info(Messages.INFO_GET_BY_ID+User.class.getSimpleName());
        User user=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_USER_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = DefaultExtractorUtil.extractUser(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_BY_ID+User.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_ID+User.class.getSimpleName(), ex);
        }
        return user;
    }

    @Override
    public void update(User obj) throws DbException {
        User old= getById(obj.getId());
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.UPDATE_USER_BY_LOGIN)) {
            int k=1;
            statement.setString(k, obj.getLogin());
            k++;
            statement.setString(k, obj.getPassword());
            k++;
            statement.setString(k, obj.getEmail());
            k++;
            statement.setLong(k, obj.getIdRole());
            k++;
            statement.setLong(k, old.getIdStatus());
            k++;
            statement.setDouble(k, old.getBill());
            k++;
            statement.setString(k, old.getLogin());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                LOG.info(Messages.INFO_SUCCESSFULLY_UPDATED+User.class.getSimpleName());
            }
            factory.commit(con);
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_UPDATE + User.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_UPDATE + User.class.getSimpleName(), ex);
        }
    }

    @Override
    public void delete(long id) throws DbException {
        try (Connection con = factory.getConnection()) {
            int rowsDeleted;
            try (PreparedStatement statement = con.prepareStatement(Queries.DELETE_USER_BY_ID)) {
                statement.setLong(1, id);
                rowsDeleted = statement.executeUpdate();
            }
            if (rowsDeleted > 0) {
                LOG.info(Messages.INFO_SUCCESSFULLY_DELETED+User.class.getSimpleName() );
            }
            factory.commit(con);
        } catch (SQLException| DbException ex) {
            LOG.error(Messages.ERROR_DELETE + User.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_DELETE + User.class.getSimpleName(), ex);
        }
    }

    @Override
    public List<User> getAll() throws DbException {
        List<User> allUsers=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_USERS)) {
                while (rs.next()) {
                    allUsers.add(DefaultExtractorUtil.extractUser(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS +User.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS +User.class.getSimpleName(), ex);
        }
        return allUsers;
    }
}
