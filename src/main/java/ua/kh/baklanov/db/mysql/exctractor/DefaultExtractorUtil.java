package ua.kh.baklanov.db.mysql.exctractor;

import org.apache.log4j.Logger;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class DefaultExtractorUtil {

    private static final Logger LOG = Logger.getLogger(DefaultExtractorUtil.class);

    private DefaultExtractorUtil(){}

    public static User extractUser(ResultSet rs) throws DbException {
        User user=new User();
        try {
            user.setId(rs.getLong("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setIdRole(rs.getLong("idRole"));
            user.setIdStatus(rs.getLong("idStatus"));
            user.setBill(rs.getDouble("bill"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+User.class.getName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+User.class.getName(), ex);
        }
        return user;
    }

    public static TV extractTV(ResultSet rs) throws DbException {
        TV tv=new TV();
        try {
            tv.setId(rs.getLong("id"));
            tv.setType(rs.getString("type"));
            tv.setNumOfChannels(rs.getInt("numOfChannels"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+TV.class.getName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+TV.class.getName(), ex);
        }
        return tv;
    }

    public static Tariff extractTariff(ResultSet rs) throws DbException {
        Tariff tariff=new Tariff();
        try {
            tariff.setId(rs.getLong("id"));
            tariff.setName(rs.getString("name"));
            tariff.setPrice(rs.getInt("price"));
            tariff.setIdService(rs.getLong("idService"));
            tariff.setDurationInDays(rs.getInt("durationInDays"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+Tariff.class.getName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+Tariff.class.getName(), ex);
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
            LOG.error(Messages.ERROR_EXTRACTING+Internet.class.getName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+Internet.class.getName(), ex);
        }
        return internet;
    }

    public static AnyTariff extractMobileTariff(ResultSet rs) throws DbException {
        AnyTariff<Mobile> mobileTariff=new AnyTariff();
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
            LOG.error(Messages.ERROR_EXTRACTING+AnyTariff.class.getName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+AnyTariff.class.getName(), ex);
        }
        mobileTariff.setService(mobile);
        return mobileTariff;
    }

    public static AnyTariff extractPCTariff(ResultSet rs) throws DbException {
        AnyTariff<PC> pcTariff=new AnyTariff();
        PC pc=new PC();
        try {
            pcTariff.setTariff(extractTariff(rs));
            pcTariff.setInternet(extractInternet(rs));
            pc.setId(rs.getLong("idPC"));
            pc.setNumOfConnectedPC(rs.getInt("numOfConnectedPC"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+AnyTariff.class.getName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+AnyTariff.class.getName(), ex);
        }
        pcTariff.setService(pc);
        return pcTariff;
    }

    public static AnyTariff extractTVTariff(ResultSet rs) throws DbException {
        AnyTariff<TV> tvTariff=new AnyTariff();
        TV tv=new TV();
        try {
            tvTariff.setTariff(extractTariff(rs));
            tvTariff.setInternet(extractInternet(rs));
            tv.setId(rs.getLong("idTV"));
            tv.setType(rs.getString("type"));
            tv.setNumOfChannels(rs.getInt("numOfChannels"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+AnyTariff.class.getName(), ex);
            throw new DbException(Messages.ERROR_EXTRACTING+AnyTariff.class.getName(), ex);
        }
        tvTariff.setService(tv);
        return tvTariff;
    }
}
