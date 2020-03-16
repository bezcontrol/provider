package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.db.mysql.DefaultFactory;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;

import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultUserDAOImpl implements UserDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultUserDAOImpl.class);

    public DefaultUserDAOImpl() throws DbException {
        try {
            factory = DAOFactory.getMySQLDAOFactory();
        } catch (DbException ex) {
            LOG.error(Messages.ERROR_CREATING_FACTORY+ DefaultFactory.class.getName(), ex);
            throw new DbException(Messages.ERROR_CREATING_FACTORY+ DefaultFactory.class.getName(), ex);
        }
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
            statement.setString(1, obj.getLogin());
            statement.setString(2, obj.getPassword());
            statement.setString(3, obj.getEmail());
            statement.setLong(4, obj.getIdRole());
            statement.setLong(5, obj.getIdStatus());
            statement.setDouble(6, obj.getBill());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                LOG.info(User.class.getName() + Messages.INFO_SUCCESSFULLY_INSERTED);
            }
            DAOFactory.commit(con);
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_INSERT + User.class.getName(), ex);
            throw new DbException(Messages.ERROR_INSERT + User.class.getName(), ex);
        }
    }

    @Override
    public User getById(long id) throws DbException {
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
            LOG.error(Messages.ERROR_GET_USER_BY_ID, ex);
            throw new DbException(Messages.ERROR_GET_USER_BY_ID, ex);
        }
        return user;
    }

    @Override
    public void update(User obj) throws DbException {
        User old= getById(obj.getId());
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.UPDATE_USER_BY_LOGIN)) {
            statement.setString(1, obj.getLogin());
            statement.setString(2, obj.getPassword());
            statement.setString(3, obj.getEmail());
            statement.setLong(4, obj.getIdRole());
            statement.setLong(5, old.getIdStatus());
            statement.setDouble(6, old.getBill());
            statement.setString(7, old.getLogin());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                LOG.info(User.class.getName() + Messages.INFO_SUCCESSFULLY_UPDATED);
            }
            DAOFactory.commit(con);
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_UPDATE + User.class.getName(), ex);
            throw new DbException(Messages.ERROR_UPDATE + User.class.getName(), ex);
        }
    }

    @Override
    public void delete(User obj) throws DbException {
        try (Connection con = factory.getConnection()) {
            int rowsDeleted;
            try (PreparedStatement statement = con.prepareStatement(Queries.DELETE_USER_BY_LOGIN)) {
                statement.setString(1, obj.getLogin());
                rowsDeleted = statement.executeUpdate();
            }
            if (rowsDeleted > 0) {
                LOG.info(User.class.getName() + Messages.INFO_SUCCESSFULLY_UPDATED);
            }
            DAOFactory.commit(con);
        } catch (SQLException| DbException ex) {
            LOG.error(Messages.ERROR_DELETE + User.class.getName(), ex);
            throw new DbException(Messages.ERROR_DELETE + User.class.getName(), ex);
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
            LOG.error(Messages.ERROR_GET_RECORDS +User.class.getName(), ex);
            throw new DbException(Messages.ERROR_GET_RECORDS +User.class.getName(), ex);
        }
        return allUsers;
    }
}
