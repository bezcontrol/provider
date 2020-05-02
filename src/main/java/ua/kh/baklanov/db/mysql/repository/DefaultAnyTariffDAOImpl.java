package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.Mobile;
import ua.kh.baklanov.model.entity.PC;
import ua.kh.baklanov.model.entity.TV;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultAnyTariffDAOImpl implements AnyTariffDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultAnyTariffDAOImpl.class);


    public DefaultAnyTariffDAOImpl(){
            factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public List<AnyTariff> getAllMobileTariffs() throws DbException {
        LOG.info(Messages.INFO_GET_ANY_TARIFF_ALL+ Mobile.class.getSimpleName());
        List<AnyTariff> allMobileTariffs=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ANY_TARIFF_ALL_MOBILE_TARIFFS)) {
                while (rs.next()) {
                    allMobileTariffs.add(DefaultExtractorUtil.extractMobileTariff(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS +AnyTariff.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS +AnyTariff.class.getSimpleName(), ex);
        }
        return allMobileTariffs;
    }

    @Override
    public List<AnyTariff> getAllPCTariffs() throws DbException {
        LOG.info(Messages.INFO_GET_ANY_TARIFF_ALL+ PC.class.getSimpleName());
        List<AnyTariff> allPCTariffs=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ANY_TARIFF_ALL_PC_TARIFFS)) {
                while (rs.next()) {
                    allPCTariffs.add(DefaultExtractorUtil.extractPCTariff(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS +AnyTariff.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS +AnyTariff.class.getSimpleName(), ex);
        }
        return allPCTariffs;
    }

    @Override
    public List<AnyTariff> getAllTVTariffs() throws DbException {
        LOG.info(Messages.INFO_GET_ANY_TARIFF_ALL+TV.class.getSimpleName());
        List<AnyTariff> allTVTariffs=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ANY_TARIFF_ALL_TV_TARIFFS)) {
                while (rs.next()) {
                    allTVTariffs.add(DefaultExtractorUtil.extractTVTariff(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS +AnyTariff.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS +AnyTariff.class.getSimpleName(), ex);
        }
        return allTVTariffs;
    }

    @Override
    public List<AnyTariff> getTVTariffsOfCurrentType(String type) throws DbException {
        LOG.info(Messages.INFO_GET_ANY_TARIFF_TV_WITH_TYPE+ type);
        List<AnyTariff> currentTypePC=new ArrayList<>();
        for (AnyTariff tariff : getAllTVTariffs()) {
            TV tv=(TV)tariff.getService();
            if(tv.getType().equals(type)){
                currentTypePC.add(tariff);
            }
        }
        return currentTypePC;
    }

    @Override
    public List<AnyTariff> getAll() throws DbException {
        LOG.info(Messages.INFO_GET_ALL_ANY_TARIFF);
        List<AnyTariff>all=new ArrayList<>();
        all.addAll(getAllMobileTariffs());
        all.addAll(getAllTVTariffs());
        all.addAll(getAllPCTariffs());
        return all;
    }
}
