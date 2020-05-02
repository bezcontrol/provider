package ua.kh.baklanov.db.mysql.extractor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.bean.UserBean;
import ua.kh.baklanov.model.entity.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultExtractorUtilTest {

    @Mock
    private static ResultSet resultSet;

    @Test
    public void extractUserTest() throws DbException, SQLException {
        customUser();
        User user = DefaultExtractorUtil.extractUser(resultSet);
        Assert.assertNotNull("is user not null", user);
    }

    @Test
    public void extractTVTest() throws DbException, SQLException {
        customTV();
        TV tv = DefaultExtractorUtil.extractTV(resultSet);
        Assert.assertNotNull("is tv not null", tv);
    }

    @Test
    public void extractPCTest() throws DbException, SQLException {
        customPC();
        PC pc = DefaultExtractorUtil.extractPC(resultSet);
        Assert.assertNotNull("is pc not null", pc);
    }

    @Test
    public void extractMobileTest() throws DbException, SQLException {
        customMobile();
        Mobile mobile = DefaultExtractorUtil.extractMobile(resultSet);
        Assert.assertNotNull("is tv not null", mobile);
    }

    @Test
    public void extractTariffTest() throws DbException, SQLException {
        customTariff();

        Tariff tariff = DefaultExtractorUtil.extractTariff(resultSet);
        Assert.assertNotNull("is tariff not null", tariff);
    }

    @Test
    public void extractInternetTest() throws DbException, SQLException {
        customInternet();

        Internet internet = DefaultExtractorUtil.extractInternet(resultSet);
        Assert.assertNotNull("is internet not null", internet);
    }

    @Test
    public void extractStatusTest() throws DbException, SQLException {
        customStatus();

        Status status = DefaultExtractorUtil.extractStatus(resultSet);
        Assert.assertNotNull("is status not null", status);
    }

    @Test
    public void extractRoleTest() throws DbException, SQLException {
        customRole();

        Role role = DefaultExtractorUtil.extractRole(resultSet);
        Assert.assertNotNull("is role not null", role);
    }

    @Test
    public void extractContractStateTest() throws DbException, SQLException {
        customContractState();

        ContractState contractState = DefaultExtractorUtil.extractContractState(resultSet);
        Assert.assertNotNull("is state not null", contractState);
    }

    @Test
    public void extractContractTest() throws DbException, SQLException {
        customContract();

        Contract contract = DefaultExtractorUtil.extractContract(resultSet);
        Assert.assertNotNull("is contract not null", contract);
    }

    @Test
    public void extractServiceTest() throws DbException, SQLException {
        customService();

        Service service = DefaultExtractorUtil.extractService(resultSet);
        Assert.assertNotNull("is service not null", service);
    }


    @Test
    public void extractUserBeanTest() throws DbException, SQLException {
        customUser();
        customRole();
        customStatus();
        UserBean userBean = DefaultExtractorUtil.extractUserBean(resultSet);
        Assert.assertNotNull("UserBean is not null", userBean);
        Assert.assertNotNull("User in UserBean is not null", userBean.getUser());
        Assert.assertNotNull("Role in UserBean is not null", userBean.getRole());
        Assert.assertNotNull("Status in UserBean is not null", userBean.getStatus());

    }

    public static void customUser() throws SQLException {
        when(resultSet.getLong("idUser")).thenReturn(1L);
        when(resultSet.getString("login")).thenReturn("admin");
        when(resultSet.getString("password")).thenReturn("password");
        when(resultSet.getString("email")).thenReturn("email@gmail.com");
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getDouble("bill")).thenReturn(100.0);
    }

    public static void customTariff() throws SQLException {
        when(resultSet.getLong("idTariff")).thenReturn(1L);
        when(resultSet.getString("tariffName")).thenReturn("tariff name");
        when(resultSet.getInt("price")).thenReturn(100);
        when(resultSet.getLong("idService")).thenReturn(1L);
        when(resultSet.getInt("durationInDays")).thenReturn(28);
    }

    public static void customRole() throws SQLException {
        when(resultSet.getLong("idRole")).thenReturn(1L);
        when(resultSet.getString("roleName")).thenReturn("admin");
    }

    public static void customStatus() throws SQLException {
        when(resultSet.getLong("idStatus")).thenReturn(1L);
        when(resultSet.getString("statusName")).thenReturn("waiting");
    }

    public static void customInternet() throws SQLException {
        when(resultSet.getLong("idInternet")).thenReturn(1L);
        when(resultSet.getInt("speed")).thenReturn(100);
        when(resultSet.getString("technology")).thenReturn("4G");
    }

    public static void customContractState() throws SQLException {
        when(resultSet.getLong("idContractState")).thenReturn(1L);
        when(resultSet.getString("contractStateName")).thenReturn("waiting");
    }

    public static void customContract() throws SQLException {
        when(resultSet.getLong("idContract")).thenReturn(1L);
        when(resultSet.getLong("idUser")).thenReturn(1L);
        when(resultSet.getLong("idTariff")).thenReturn(1L);
        when(resultSet.getLong("idContractState")).thenReturn(1L);
        when(resultSet.getDate("contractExpirationDate"))
                .thenReturn(Date.valueOf(LocalDateTime.now().toLocalDate()));
        when(resultSet.getDate("contractConclusionDate"))
                .thenReturn(Date.valueOf(LocalDateTime.now().toLocalDate()));
    }

    private void customService() throws SQLException {
        when(resultSet.getLong("idService")).thenReturn(1L);
        when(resultSet.getLong("idPC")).thenReturn(1L);
        when(resultSet.getLong("idTV")).thenReturn(1L);
        when(resultSet.getLong("idMobile")).thenReturn(1L);
        when(resultSet.getLong("idInternet")).thenReturn(1L);
    }

    private void customTV() throws SQLException {
        when(resultSet.getLong("idTV")).thenReturn(1L);
        when(resultSet.getString("type")).thenReturn("Analog");
        when(resultSet.getInt("numOfChannels")).thenReturn(10);
    }

    private void customPC() throws SQLException {
        when(resultSet.getLong("idPC")).thenReturn(1L);
        when(resultSet.getInt("numOfConnectedPC")).thenReturn(10);
    }

    private void customMobile() throws SQLException {
        when(resultSet.getLong("idMobile")).thenReturn(1L);
        when(resultSet.getInt("numOfMinutesInside")).thenReturn(10);
        when(resultSet.getInt("numOfMinutesOutside")).thenReturn(10);
        when(resultSet.getInt("numOfMbts")).thenReturn(10);
        when(resultSet.getInt("numOfSMS")).thenReturn(10);
    }
}
