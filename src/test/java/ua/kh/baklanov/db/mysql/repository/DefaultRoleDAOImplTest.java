package ua.kh.baklanov.db.mysql.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ua.kh.baklanov.db.mysql.DefaultFactory;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.Status;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultRoleDAOImplTest {

    @InjectMocks
    private DefaultRoleDAOImpl roleDAO;
    @Mock
    private DefaultFactory factory;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private Statement statement;

    @Mock
    private ResultSet resultSet;

    @Test
    public void getStatusByNameTest() throws DbException, SQLException {
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getString("roleName")).thenReturn("admin");

        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(Queries.GET_ROLE_BY_NAME)).thenReturn(preparedStatement);
        when(factory.getConnection()).thenReturn(connection);
        Role role=roleDAO.getRoleByName("waiting");
        Assert.assertNotNull("is role not null", role);
        Assert.assertEquals("are role id's equal", Optional.of(1L), Optional.ofNullable(role.getId()));
    }

    @Test
    public void getAllTest() throws DbException, SQLException {
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getString("roleName")).thenReturn("waiting");

        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(statement.executeQuery(Queries.GET_ALL_ROLES)).thenReturn(resultSet);
        when(connection.createStatement()).thenReturn(statement);
        when(factory.getConnection()).thenReturn(connection);
        List<Role> roles=roleDAO.getAll();
        Assert.assertNotNull("is roles not null", roles);
        Assert.assertTrue("is roles list size more than 0", roles.size()>0);
    }
}
