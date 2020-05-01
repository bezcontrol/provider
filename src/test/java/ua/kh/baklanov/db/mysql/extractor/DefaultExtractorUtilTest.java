package ua.kh.baklanov.db.mysql.extractor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultExtractorUtilTest {

    @Mock
    private ResultSet resultSet;

    @Test
    public void extractUserTest() throws DbException, SQLException {
        when(resultSet.getLong("idUser")).thenReturn(1L);
        when(resultSet.getString("login")).thenReturn("admin");
        when(resultSet.getString("password")).thenReturn("password");
        when(resultSet.getString("email")).thenReturn("email@gmail.com");
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getDouble("bill")).thenReturn(100.0);

        User user=DefaultExtractorUtil.extractUser(resultSet);
        Assert.assertNotNull("is user not null", user);
    }

    @Test
    public void extractTVTest() throws DbException, SQLException {
        when(resultSet.getLong("idTV")).thenReturn(1L);
        when(resultSet.getString("type")).thenReturn("Analog");
        when(resultSet.getInt("numOfChannels")).thenReturn(10);
        TV tv=DefaultExtractorUtil.extractTV(resultSet);
        Assert.assertNotNull("is tv not null", tv);
    }


    @Test
    public void extractTariffTest() throws DbException, SQLException {
        when(resultSet.getLong("idTariff")).thenReturn(1L);
        when(resultSet.getString("tariffName")).thenReturn("tariff name");
        when(resultSet.getInt("price")).thenReturn(100);
        when(resultSet.getLong("idService")).thenReturn(1L);
        when(resultSet.getInt("durationInDays")).thenReturn(28);

        Tariff tariff=DefaultExtractorUtil.extractTariff(resultSet);
        Assert.assertNotNull("is tariff not null", tariff);
    }

    @Test
    public void extractInternetTest() throws DbException, SQLException {
        when(resultSet.getLong("idInternet")).thenReturn(1L);
        when(resultSet.getInt("speed")).thenReturn(100);
        when(resultSet.getString("technology")).thenReturn("4G");

        Internet internet=DefaultExtractorUtil.extractInternet(resultSet);
        Assert.assertNotNull("is internet not null", internet);
    }

    @Test
    public void extractStatusTest() throws DbException, SQLException {
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getString("statusName")).thenReturn("waiting");

        Status status=DefaultExtractorUtil.extractStatus(resultSet);
        Assert.assertNotNull("is status not null", status);
    }

    @Test
    public void extractRoleTest() throws DbException, SQLException {
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getString("roleName")).thenReturn("admin");

        Role role=DefaultExtractorUtil.extractRole(resultSet);
        Assert.assertNotNull("is role not null", role);
    }

    @Test
    public void extractContractStateTest() throws DbException, SQLException {
        when(resultSet.getLong("idContractState")).thenReturn(1L);
        when(resultSet.getString("contractStateName")).thenReturn("waiting");

        ContractState contractState=DefaultExtractorUtil.extractContractState(resultSet);
        Assert.assertNotNull("is state not null", contractState);
    }

    @Test
    public void extractContractTest() throws DbException, SQLException {
        when(resultSet.getLong("idContract")).thenReturn(1L);
        when(resultSet.getLong("idUser")).thenReturn(1L);
        when(resultSet.getLong("idTariff")).thenReturn(1L);
        when(resultSet.getLong("idContractState")).thenReturn(1L);
        when(resultSet.getDate("contractExpirationDate"))
                .thenReturn(Date.valueOf(LocalDateTime.now().toLocalDate()));
        when(resultSet.getDate("contractConclusionDate"))
                .thenReturn(Date.valueOf(LocalDateTime.now().toLocalDate()));

        Contract contract=DefaultExtractorUtil.extractContract(resultSet);
        Assert.assertNotNull("is contract not null", contract);
    }
}
