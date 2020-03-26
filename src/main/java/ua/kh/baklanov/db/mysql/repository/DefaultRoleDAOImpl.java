package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.RoleDAO;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultRoleDAOImpl implements RoleDAO {
    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultRoleDAOImpl.class);

    public DefaultRoleDAOImpl() {
        factory = DAOFactory.getDefaultFactory();
    }
    @Override
    public Role getRoleByName(String name) throws DbException {
        LOG.info(Messages.INFO_GET_BY_NAME+ Role.class.getSimpleName());
        Role role=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_ROLE_BY_NAME)) {
            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    role = DefaultExtractorUtil.extractRole(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_BY_NAME+Role.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_NAME+Role.class.getSimpleName(), ex);
        }
        return role;
    }

    @Override
    public List<Role> getAll() throws DbException {
        List<Role> allRoles=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_ROLES)) {
                while (rs.next()) {
                    allRoles.add(DefaultExtractorUtil.extractRole(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS +Role.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS +Role.class.getSimpleName(), ex);
        }
        return allRoles;
    }
}
