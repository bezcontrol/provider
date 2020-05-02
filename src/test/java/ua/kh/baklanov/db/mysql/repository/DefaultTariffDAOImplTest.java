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
import ua.kh.baklanov.model.entity.Tariff;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultTariffDAOImplTest {

    @InjectMocks
    private DefaultTariffDAOImpl tariffDAO;
    @Mock
    private DefaultFactory factory;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @Test
    public void getByIdTest() throws DbException, SQLException {
        when(resultSet.getLong("idTariff")).thenReturn(1L);
        when(resultSet.getString("tariffName")).thenReturn("tariff name");
        when(resultSet.getInt("price")).thenReturn(100);
        when(resultSet.getLong("idService")).thenReturn(1L);
        when(resultSet.getInt("durationInDays")).thenReturn(28);

        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(Queries.GET_TARIFF_BY_ID)).thenReturn(preparedStatement);
        when(factory.getConnection()).thenReturn(connection);
        Tariff tariff=tariffDAO.getById(1L);
        Assert.assertNotNull("is tariff not null", tariff);
        Assert.assertEquals("are tariff id's equal", Optional.of(1L), Optional.ofNullable(tariff.getId()));
    }

}
