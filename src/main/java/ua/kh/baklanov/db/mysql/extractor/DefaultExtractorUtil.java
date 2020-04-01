package ua.kh.baklanov.db.mysql.extractor;

import org.apache.log4j.Logger;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyService;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.bean.UserBean;
import ua.kh.baklanov.model.bean.ContractBean;
import ua.kh.baklanov.model.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public final class DefaultExtractorUtil {

    private static final Logger LOG = Logger.getLogger(DefaultExtractorUtil.class);

    private DefaultExtractorUtil(){}

    public static User extractUser(ResultSet rs) throws DbException {
        User user=new User();
        try {
            user.setId(rs.getLong("idUser"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setIdRole(rs.getLong("idRole"));
            user.setIdStatus(rs.getLong("idStatus"));
            user.setBill(rs.getDouble("bill"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+User.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+User.class.getSimpleName(), ex);
        }
        return user;
    }

    public static TV extractTV(ResultSet rs) throws DbException {
        TV tv=new TV();
        try {
            tv.setId(rs.getLong("idTV"));
            tv.setType(rs.getString("type"));
            tv.setNumOfChannels(rs.getInt("numOfChannels"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+TV.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+TV.class.getSimpleName(), ex);
        }
        return tv;
    }

    public static Tariff extractTariff(ResultSet rs) throws DbException {
        Tariff tariff=new Tariff();
        try {
            tariff.setId(rs.getLong("idTariff"));
            tariff.setName(rs.getString("tariffName"));
            tariff.setPrice(rs.getInt("price"));
            tariff.setIdService(rs.getLong("idService"));
            tariff.setDurationInDays(rs.getInt("durationInDays"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+Tariff.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+Tariff.class.getSimpleName(), ex);
        }
        return tariff;
    }

    public static Internet extractInternet(ResultSet rs) throws DbException {
        Internet internet=new Internet();
        try {
            internet.setId(rs.getLong("idInternet"));
            internet.setSpeed(rs.getInt("speed"));
            internet.setTechnology(rs.getString("technology"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+Internet.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+Internet.class.getSimpleName(), ex);
        }
        return internet;
    }

    public static AnyTariff extractMobileTariff(ResultSet rs) throws DbException {
        AnyTariff<Mobile> mobileTariff=new AnyTariff<>();
        Mobile mobile=new Mobile();
        try {
            mobileTariff.setTariff(extractTariff(rs));
            mobileTariff.setInternet(extractInternet(rs));
            mobile.setId(rs.getLong("idMobile"));
            mobile.setNumOfMinutesInside(rs.getInt("numOfMinutesInside"));
            mobile.setNumOfMinutesOutside(rs.getInt("numOfMinutesOutside"));
            mobile.setNumOfSMS(rs.getInt("numOfSMS"));
            mobile.setNumOfMbts(rs.getInt("numOfMbts"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+AnyTariff.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+AnyTariff.class.getSimpleName(), ex);
        }
        mobileTariff.setService(mobile);
        return mobileTariff;
    }

    public static AnyTariff extractPCTariff(ResultSet rs) throws DbException {
        AnyTariff<PC> pcTariff=new AnyTariff<>();
        PC pc=new PC();
        try {
            pcTariff.setTariff(extractTariff(rs));
            pcTariff.setInternet(extractInternet(rs));
            pc.setId(rs.getLong("idPC"));
            pc.setNumOfConnectedPC(rs.getInt("numOfConnectedPC"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+AnyTariff.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+AnyTariff.class.getSimpleName(), ex);
        }
        pcTariff.setService(pc);
        return pcTariff;
    }

    public static AnyTariff extractTVTariff(ResultSet rs) throws DbException {
        AnyTariff<TV> tvTariff=new AnyTariff<>();
        TV tv=new TV();
        try {
            tvTariff.setTariff(extractTariff(rs));
            tvTariff.setInternet(extractInternet(rs));
            tv.setId(rs.getLong("idTV"));
            tv.setType(rs.getString("type"));
            tv.setNumOfChannels(rs.getInt("numOfChannels"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+AnyTariff.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+AnyTariff.class.getSimpleName(), ex);
        }
        tvTariff.setService(tv);
        return tvTariff;
    }

    public static Service extractService(ResultSet rs) throws DbException {
        Service service=new Service();
        try {
            service.setId(rs.getLong("idService"));
            service.setIdPC(rs.getLong("idPC"));
            service.setIdTV(rs.getLong("idTV"));
            service.setIdMobile(rs.getLong("idMobile"));
            service.setIdInternet(rs.getLong("idInternet"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+Service.class.getSimpleName(),ex);
            throw new DbException(Messages.ERROR_EXTRACTING+Service.class.getSimpleName(), ex);
        }
        return service;
    }

    public static PC extractPC(ResultSet rs) throws DbException {
        PC pc=new PC();
        try {
            pc.setId(rs.getLong("idPC"));
            pc.setNumOfConnectedPC(rs.getInt("numOfConnectedPC"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+PC.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+PC.class.getSimpleName(), ex);
        }
        return pc;
    }

    public static Mobile extractMobile(ResultSet rs) throws DbException {
        Mobile mobile=new Mobile();
        try {
            mobile.setId(rs.getLong("idMobile"));
            mobile.setNumOfMinutesInside(rs.getInt("numOfMinutesInside"));
            mobile.setNumOfMinutesOutside(rs.getInt("numOfMinutesOutside"));
            mobile.setNumOfMbts(rs.getInt("numOfMbts"));
            mobile.setNumOfSMS(rs.getInt("numOfSMS"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+Mobile.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+Mobile.class.getSimpleName(), ex);
        }
        return mobile;
    }

    public static AnyService extractAnyServicePC(ResultSet rs) throws DbException {
        AnyService<PC> anyService=new AnyService();
        try {
            anyService.setDescription(rs.getString("description"));
            anyService.setInternet(extractInternet(rs));
            anyService.setService(extractPC(rs));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+AnyService.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+AnyService.class.getSimpleName(), ex);
        }

        return anyService;
    }

    public static AnyService extractAnyServiceTV(ResultSet rs) throws DbException {
        AnyService<TV> anyService=new AnyService();
        try {
            anyService.setInternet(extractInternet(rs));
            anyService.setService(extractTV(rs));
            anyService.setDescription(rs.getString("description"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+AnyService.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+AnyService.class.getSimpleName(), ex);
        }
        return anyService;
    }

    public static AnyService extractAnyServiceMobile(ResultSet rs) throws DbException {
        AnyService<Mobile> anyService=new AnyService();
        try {
            anyService.setInternet(extractInternet(rs));
            anyService.setService(extractMobile(rs));
            anyService.setDescription(rs.getString("description"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+AnyService.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+AnyService.class.getSimpleName(), ex);
        }
        return anyService;
    }

    public static UserBean extractUserBean(ResultSet rs) throws DbException {
        UserBean bean=new UserBean();
        bean.setUser(extractUser(rs));
        bean.setRole(extractRole(rs));
        bean.setStatus(extractStatus(rs));
        return bean;
    }

    public static Status extractStatus(ResultSet rs) throws DbException {
        Status status=new Status();
        try {
            status.setId(rs.getLong("idStatus"));
            status.setName(rs.getString("statusName"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+Status.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+Status.class.getSimpleName(), ex);
        }
        return status;
    }

    public static Role extractRole(ResultSet rs) throws DbException {
        Role role = new Role();
        try {
            role.setId(rs.getLong("idRole"));
            role.setName(rs.getString("roleName"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+Role.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+Role.class.getSimpleName(), ex);
        }
        return role;
    }

    public static ContractState extractContractState(ResultSet rs) throws DbException {
        ContractState state=new ContractState();
        try {
            state.setId(rs.getLong("idContractState"));
            state.setName(rs.getString("contractStateName"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+ContractState.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+ContractState.class.getSimpleName(), ex);
        }
        return state;
    }

    public static ContractBean extractUserContractBean(ResultSet rs) throws DbException {
        ContractBean bean=new ContractBean();
        bean.setUserBean(extractUserBean(rs));
        bean.setTariff(extractTariff(rs));
        bean.setContract(extractContract(rs));
        bean.setContractState(extractContractState(rs));
        return bean;
    }

    private static Contract extractContract(ResultSet rs) throws DbException {
        Contract contract=new Contract();
        try {
            contract.setId(rs.getLong("idContract"));
            contract.setIdUser(rs.getLong("idUser"));
            contract.setIdTariff(rs.getLong("idTariff"));
            contract.setIdContractState(rs.getLong("idContractState"));
            contract.setContractExpirationDate(new Timestamp(rs.getDate("contractExpirationDate")
                    .getTime()).toLocalDateTime());
            contract.setContractConclusionDate(new Timestamp(rs.getDate("contractConclusionDate")
                    .getTime()).toLocalDateTime());
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+Contract.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+Contract.class.getSimpleName(), ex);
        }
        return contract;
    }
}
