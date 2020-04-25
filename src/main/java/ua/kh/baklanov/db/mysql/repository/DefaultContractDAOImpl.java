package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.ContractDAO;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Contract;
import ua.kh.baklanov.model.entity.Internet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultContractDAOImpl implements ContractDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultContractDAOImpl.class);

    public DefaultContractDAOImpl() {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public void insert(Contract obj) throws DbException {
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.INSERT_CONTRACT)) {
            int k=1;
            statement.setLong(k, obj.getIdUser());
            k++;
            statement.setLong(k, obj.getIdTariff());
            k++;
            statement.setLong(k,obj.getIdContractState());
            k++;
            statement.setObject(k, obj.getContractConclusionDate());
            k++;
            statement.setObject(k, obj.getContractExpirationDate());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                LOG.info(Messages.INFO_SUCCESSFULLY_INSERTED+ Contract.class.getSimpleName());
            }
            factory.commit(con);
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_INSERT + Contract.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_INSERT + Contract.class.getSimpleName(), ex);
        }
    }

    @Override
    public Contract getById(long id) throws DbException {
        LOG.info(Messages.INFO_GET_BY_ID + Contract.class.getSimpleName());
        Contract contract = null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_CONTRACT_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    contract = DefaultExtractorUtil.extractContract(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_BY_ID + Contract.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_ID + Contract.class.getSimpleName(), ex);
        }
        return contract;
    }

    @Override
    public void update(Contract obj) throws DbException {
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.UPDATE_CONTRACT)) {
            int k=1;
            statement.setLong(k, obj.getIdUser());
            k++;
            statement.setLong(k, obj.getIdTariff());
            k++;
            statement.setLong(k, obj.getIdContractState());
            k++;
            statement.setObject(k, obj.getContractConclusionDate());
            k++;
            statement.setObject(k, obj.getContractExpirationDate());
            k++;
            statement.setObject(k, obj.getId());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                LOG.info(Messages.INFO_SUCCESSFULLY_UPDATED+Contract.class.getSimpleName());
            }
            factory.commit(con);
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_UPDATE + Contract.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_UPDATE + Contract.class.getSimpleName(), ex);
        }
    }

    @Override
    public void delete(long id) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        return new ArrayList();
    }
}
