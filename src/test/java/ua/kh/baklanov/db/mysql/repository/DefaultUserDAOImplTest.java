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
import ua.kh.baklanov.model.entity.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserDAOImplTest {

    @InjectMocks
    private DefaultUserDAOImpl userDAO;
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
    public void getByLogin() throws DbException, SQLException {
        when(resultSet.getLong("idUser")).thenReturn(1L);
        when(resultSet.getString("login")).thenReturn("admin");
        when(resultSet.getString("password")).thenReturn("password");
        when(resultSet.getString("email")).thenReturn("email@gmail.com");
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getDouble("bill")).thenReturn(100.0);

        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(Queries.GET_USER_BY_LOGIN)).thenReturn(preparedStatement);
        when(factory.getConnection()).thenReturn(connection);
        User user=userDAO.getByLogin("admin");
        Assert.assertNotNull("is user not null",user);
        Assert.assertEquals("are user id's equal", Optional.of(1L), java.util.Optional.ofNullable(user.getId()));
    }

    @Test
    public void getByEmail() throws DbException, SQLException {
        when(resultSet.getLong("idUser")).thenReturn(1L);
        when(resultSet.getString("login")).thenReturn("admin");
        when(resultSet.getString("password")).thenReturn("password");
        when(resultSet.getString("email")).thenReturn("email@gmail.com");
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getDouble("bill")).thenReturn(100.0);

        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(Queries.GET_USER_BY_EMAIL)).thenReturn(preparedStatement);
        when(factory.getConnection()).thenReturn(connection);
        User user=userDAO.getByEmail("email@gmail.com");
        Assert.assertNotNull("is user not null",user);
        Assert.assertEquals("are user id's equal", Optional.of(1L), java.util.Optional.ofNullable(user.getId()));
    }


    @Test
    public void getById() throws DbException, SQLException {
        when(resultSet.getLong("idUser")).thenReturn(1L);
        when(resultSet.getString("login")).thenReturn("admin");
        when(resultSet.getString("password")).thenReturn("password");
        when(resultSet.getString("email")).thenReturn("email@gmail.com");
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getDouble("bill")).thenReturn(100.0);

        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(Queries.GET_USER_BY_ID)).thenReturn(preparedStatement);
        when(factory.getConnection()).thenReturn(connection);
        User user=userDAO.getById(1L);
        Assert.assertNotNull("is user not null", user);
        Assert.assertEquals("are user id's equal", Optional.of(1L), java.util.Optional.ofNullable(user.getId()));
    }

    @Test
    public void getAll() throws DbException, SQLException {
        when(resultSet.getLong("idUser")).thenReturn(1L);
        when(resultSet.getString("login")).thenReturn("admin");
        when(resultSet.getString("password")).thenReturn("password");
        when(resultSet.getString("email")).thenReturn("email@gmail.com");
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getDouble("bill")).thenReturn(100.0);

        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(statement.executeQuery(Queries.GET_ALL_USERS)).thenReturn(resultSet);
        when(connection.createStatement()).thenReturn(statement);
        when(factory.getConnection()).thenReturn(connection);
        List<User> users=userDAO.getAll();
        Assert.assertNotNull("is users list not null", users);
        Assert.assertTrue("is users list size more than 0",users.size()>0);
    }
}
