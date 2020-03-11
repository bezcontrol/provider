package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.db.mysql.MySQLFactory;
import ua.kh.baklanov.db.mysql.exctractor.MySQLExtractorUtil;

import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAOImpl implements UserDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(MySQLUserDAOImpl.class);

    public MySQLUserDAOImpl() throws DbException {
        try {
            factory = MySQLFactory.getInstance();
        } catch (DbException ex) {
            LOG.error(Messages.ERROR_CREATING_FACTORY+MySQLFactory.class.getName(), ex);
            throw new DbException(Messages.ERROR_CREATING_FACTORY+MySQLFactory.class.getName(), ex);
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
                    user = MySQLExtractorUtil.extractUser(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_USER_BY_LOGIN, ex);
            throw new DbException(Messages.ERROR_GET_USER_BY_LOGIN, ex);
        }
        return user;
    }

    @Override
    public void insert(Object obj) throws DbException {
        User user = (User) obj;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.INSERT_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setLong(4, user.getIdRole());

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
    public Object getById(long id) throws DbException {
        User user=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_USER_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = MySQLExtractorUtil.extractUser(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_USER_BY_ID, ex);
            throw new DbException(Messages.ERROR_GET_USER_BY_ID, ex);
        }
        return user;
    }

    @Override
    public void update(Object obj) throws DbException {
        User user = (User) obj;
        User old= (User) getById(user.getId());
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.UPDATE_USER_BY_LOGIN)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setLong(4, user.getIdRole());
            statement.setLong(5, old.getId());
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
    public void delete(Object obj) throws DbException {
        User user= (User) obj;
        try (Connection con = factory.getConnection();) {
            int rowsDeleted;
            try (PreparedStatement statement = con.prepareStatement(Queries.DELETE_USER_BY_LOGIN)) {
                statement.setString(1, user.getLogin());
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
                    allUsers.add(MySQLExtractorUtil.extractUser(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS+User.class.getName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS+User.class.getName(), ex);
        }
        return allUsers;
    }
}
