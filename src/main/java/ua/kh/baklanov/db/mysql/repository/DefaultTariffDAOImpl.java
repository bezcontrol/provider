package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.db.mysql.exctractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Tariff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DefaultTariffDAOImpl implements TariffDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultTariffDAOImpl.class);


    public DefaultTariffDAOImpl() {
            factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public void insert(Tariff obj) throws DbException {

    }

    @Override
    public Tariff getById(long id) throws DbException {
        LOG.info(Messages.INFO_GET_BY_ID+Tariff.class.getSimpleName());
        Tariff tariff=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_TARIFF_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    tariff = DefaultExtractorUtil.extractTariff(rs);
                }
            }
        } catch (DbException | SQLException ex) {
            LOG.error(Messages.ERROR_GET_BY_ID+Tariff.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_ID+Tariff.class.getSimpleName(), ex);
        }
        return tariff;
    }

    @Override
    public void update(Tariff obj) throws DbException {

    }

    @Override
    public void delete(Tariff obj) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        return null;
    }
}
