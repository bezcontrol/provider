package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.ContractStateDAO;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.ContractState;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DefaultContractStateDAOImpl implements ContractStateDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultContractStateDAOImpl.class);

    public DefaultContractStateDAOImpl() {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public ContractState getStatusByName(String name) throws DbException {
        LOG.info(Messages.INFO_GET_BY_NAME+ ContractState.class.getSimpleName());
        ContractState state=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_CONTRACT_STATE_BY_NAME)) {
            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    state = DefaultExtractorUtil.extractContractState(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_BY_NAME+ContractState.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_NAME+ContractState.class.getSimpleName(), ex);
        }
        return state;
    }

    @Override
    public List<ContractState> getAll() throws DbException {
        return null;
    }
}
