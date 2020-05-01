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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private ResultSet resultSet;

    @Test
    public void getByLogin() throws DbException, SQLException {
        when(resultSet.getLong("idUser")).thenReturn(1L);

        /**
         *  подряд getSmth() с возвращением полей, которые должны быть у админа
         *  после этого их сетить в user (строка 51) и в конце assert делать на этом user
         * */

        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(Queries.GET_USER_BY_LOGIN)).thenReturn(preparedStatement);
        when(factory.getConnection()).thenReturn(connection);
        User user=userDAO.getByLogin("admin");
        Assert.assertEquals(Optional.of(1L), java.util.Optional.ofNullable(user.getId()));
    }
}
