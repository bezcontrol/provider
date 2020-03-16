package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.db.mysql.DefaultFactory;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.TV;
import ua.kh.baklanov.model.entity.Tariff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultAnyTariffDAOImpl implements AnyTariffDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultAnyTariffDAOImpl.class);


    public DefaultAnyTariffDAOImpl() throws DbException {
        try {
            factory = DAOFactory.getMySQLDAOFactory();
        } catch (DbException ex) {
            LOG.error(Messages.ERROR_CREATING_FACTORY+ DefaultFactory.class.getName(), ex);
            throw new DbException(Messages.ERROR_CREATING_FACTORY+ DefaultFactory.class.getName(), ex);
        }
    }

    @Override
    public List<AnyTariff> getAllMobileTariffs() throws DbException {
        List<AnyTariff> allMobileTariffs=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_MOBILE_TARIFFS)) {
                while (rs.next()) {
                    allMobileTariffs.add(DefaultExtractorUtil.extractMobileTariff(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_RECORDS +AnyTariff.class.getName(), ex);
            throw new DbException(Messages.ERROR_GET_RECORDS +AnyTariff.class.getName(), ex);
        }
        return allMobileTariffs;
    }

    @Override
    public List<AnyTariff> getAllPCTariffs() throws DbException {
        List<AnyTariff> allPCTariffs=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_PC_TARIFFS)) {
                while (rs.next()) {
                    allPCTariffs.add(DefaultExtractorUtil.extractPCTariff(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_RECORDS +AnyTariff.class.getName(), ex);
            throw new DbException(Messages.ERROR_GET_RECORDS +AnyTariff.class.getName(), ex);
        }
        return allPCTariffs;
    }

    @Override
    public List<AnyTariff> getAllTVTariffs() throws DbException {
        List<AnyTariff> allTVTariffs=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_TV_TARIFFS)) {
                while (rs.next()) {
                    allTVTariffs.add(DefaultExtractorUtil.extractTVTariff(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_RECORDS +AnyTariff.class.getName(), ex);
            throw new DbException(Messages.ERROR_GET_RECORDS +AnyTariff.class.getName(), ex);
        }
        return allTVTariffs;
    }

    @Override
    public List<AnyTariff> getTVTariffsOfCurrentType(String type) throws DbException {
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
    public void insert(AnyTariff obj) throws DbException {

    }

    @Override
    public AnyTariff getById(long id) throws DbException {
        return null;
    }

    @Override
    public void update(AnyTariff obj) throws DbException {

    }

    @Override
    public void delete(AnyTariff obj) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        List<AnyTariff>all=new ArrayList<>();
        all.addAll(getAllMobileTariffs());
        all.addAll(getAllTVTariffs());
        all.addAll(getAllPCTariffs());
        return all;
    }
}
