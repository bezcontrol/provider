package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.ContractBeanDAO;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.ContractBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            try (ResultSet rs = statement.executeQuery(Queries.GET_ALL_USER_CONTRACTS)) {
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
}
