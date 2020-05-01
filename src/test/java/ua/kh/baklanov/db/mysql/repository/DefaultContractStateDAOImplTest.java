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
import ua.kh.baklanov.model.entity.ContractState;
import ua.kh.baklanov.model.entity.Status;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultContractStateDAOImplTest {

    @InjectMocks
    private DefaultContractStateDAOImpl contractStateDAO;
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
    public void getContractStateByNameTest() throws DbException, SQLException {
        when(resultSet.getLong("idContractState")).thenReturn(1L);
        when(resultSet.getString("contractStateName")).thenReturn("waiting");

        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(connection.prepareStatement(Queries.GET_CONTRACT_STATE_BY_NAME)).thenReturn(preparedStatement);
        when(factory.getConnection()).thenReturn(connection);
        ContractState contractState=contractStateDAO.getStatusByName("waiting");
        Assert.assertNotNull("is contract state not null", contractState);
        Assert.assertEquals("are contract state id's equal", Optional.of(1L),
                Optional.ofNullable(contractState.getId()));
    }

    @Test
    public void getAllTest() throws DbException, SQLException {
        when(resultSet.getLong("idContractState")).thenReturn(1L);
        when(resultSet.getString("contractStateName")).thenReturn("waiting");

        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(statement.executeQuery(Queries.GET_ALL_CONTRACT_STATES)).thenReturn(resultSet);
        when(connection.createStatement()).thenReturn(statement);
        when(factory.getConnection()).thenReturn(connection);
        List<ContractState> contractStates=contractStateDAO.getAll();
        Assert.assertNotNull("is contract states not null", contractStates);
        Assert.assertTrue("is states list size more than 0", contractStates.size()>0);
    }

}
