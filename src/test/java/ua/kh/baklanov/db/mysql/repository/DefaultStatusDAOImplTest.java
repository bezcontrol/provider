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
import ua.kh.baklanov.model.entity.Status;
import ua.kh.baklanov.model.entity.TV;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultStatusDAOImplTest {

    @InjectMocks
    private DefaultStatusDAOImpl statusDAO;
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
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getString("statusName")).thenReturn("waiting");

        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(Queries.GET_STATUS_BY_NAME)).thenReturn(preparedStatement);
        when(factory.getConnection()).thenReturn(connection);
        Status status=statusDAO.getStatusByName("waiting");
        Assert.assertNotNull("is status not null", status);
        Assert.assertEquals("are status id's equal", Optional.of(1L), Optional.ofNullable(status.getId()));
    }

    @Test
    public void getAllTest() throws DbException, SQLException {
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getString("statusName")).thenReturn("waiting");

        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(statement.executeQuery(Queries.GET_ALL_STATUSES)).thenReturn(resultSet);
        when(connection.createStatement()).thenReturn(statement);
        when(factory.getConnection()).thenReturn(connection);
        List<Status> statuses=statusDAO.getAll();
        Assert.assertNotNull("is tvs not null", statuses);
        Assert.assertTrue("is tvs list size more than 0", statuses.size()>0);
    }

}
