package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.ContractBeanDAO;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.ContractBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultContractBeanDAOImpl implements ContractBeanDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultContractBeanDAOImpl.class);

    public DefaultContractBeanDAOImpl() {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public List<ContractBean> getAll() throws DbException {
        List<ContractBean> allContracts=new ArrayList<>();
        try (Connection con = factory.getConnection();
             Statement statement = con.createStatement()) {
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_CONTRACT_BEANS)) {
                while (rs.next()) {
                    allContracts.add(DefaultExtractorUtil.extractUserContractBean(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS + ContractBean.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS + ContractBean.class.getSimpleName(), ex);
        }
        return allContracts;
    }

    @Override
    public List<ContractBean> getContractBeansByUserId(long userId) throws DbException {
        List<ContractBean> allUserContracts=new ArrayList<>();
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_ALL_USER_CONTRACTS)) {
            statement.setLong(1, userId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    allUserContracts.add(DefaultExtractorUtil.extractUserContractBean(rs));
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_ALL_RECORDS + ContractBean.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_ALL_RECORDS + ContractBean.class.getSimpleName(), ex);
        }
        return allUserContracts;
    }
}
