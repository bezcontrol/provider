package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.UserBeanDAO;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultUserBeanDAOImpl implements UserBeanDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultUserBeanDAOImpl.class);

    public DefaultUserBeanDAOImpl()  {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public List getAll() throws DbException {
        List<UserBean> allUsers=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_USERS_INFO)) {
                while (rs.next()) {
                    allUsers.add(DefaultExtractorUtil.extractUserBean(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS +UserBean.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS +UserBean.class.getSimpleName(), ex);
        }
        return allUsers;
    }

    @Override
    public UserBean getByLogin(String login) throws DbException {
        UserBean user=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_USER_BEAN_BY_LOGIN)) {
            statement.setString(1, login);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = DefaultExtractorUtil.extractUserBean(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_USER_BY_LOGIN, ex);
            throw new DbException(Messages.ERROR_GET_USER_BEAN_BY_LOGIN, ex);
        }
        return user;
    }

    @Override
    public UserBean getByEmail(String email) throws DbException {
        UserBean user=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_USER_BEAN_BY_EMAIL)) {
            statement.setString(1, email);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = DefaultExtractorUtil.extractUserBean(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_USER_BEAN_BY_EMAIL, ex);
            throw new DbException(Messages.ERROR_GET_USER_BEAN_BY_EMAIL, ex);
        }
        return user;
    }
}
