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
import ua.kh.baklanov.model.entity.TV;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultTVDAOImplTest {

    @InjectMocks
    private DefaultTVDAOImpl tvdao;
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
    public void getByIdTest() throws DbException, SQLException {
        when(resultSet.getLong("idTV")).thenReturn(1L);
        when(resultSet.getString("type")).thenReturn("Analog");
        when(resultSet.getInt("numOfChannels")).thenReturn(10);

        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(Queries.GET_TV_BY_ID)).thenReturn(preparedStatement);
        when(factory.getConnection()).thenReturn(connection);
        TV tv=tvdao.getById(1L);
        Assert.assertNotNull("is tv not null", tv);
        Assert.assertEquals("are tv id's equal", Optional.of(1L), Optional.ofNullable(tv.getId()));
    }

    @Test
    public void getAllTest() throws DbException, SQLException {
        when(resultSet.getLong("idTV")).thenReturn(1L);
        when(resultSet.getString("type")).thenReturn("Analog");
        when(resultSet.getInt("numOfChannels")).thenReturn(10);

        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(statement.executeQuery(Queries.GET_ALL_TV)).thenReturn(resultSet);
        when(connection.createStatement()).thenReturn(statement);
        when(factory.getConnection()).thenReturn(connection);
        List<TV> tvs=tvdao.getAll();
        Assert.assertNotNull("is tvs not null", tvs);
        Assert.assertTrue("is tvs list size more than 0", tvs.size()>0);
    }

    @Test
    public void getTypesTest() throws DbException, SQLException {
        when(resultSet.getLong("idTV")).thenReturn(1L);
        when(resultSet.getString("type")).thenReturn("Analog");
        when(resultSet.getInt("numOfChannels")).thenReturn(10);

        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(statement.executeQuery(Queries.GET_ALL_TV)).thenReturn(resultSet);
        when(connection.createStatement()).thenReturn(statement);
        when(factory.getConnection()).thenReturn(connection);
        List<String> types=tvdao.getTypes();
        Assert.assertNotNull("is list with types of tvs not null", types);
        Assert.assertTrue("is list with types of tvs size more than 0",types.size()>0);
    }
}
