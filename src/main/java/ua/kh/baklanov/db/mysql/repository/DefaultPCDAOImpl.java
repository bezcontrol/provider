package ua.kh.baklanov.db.mysql.repository;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.PCDAO;
import ua.kh.baklanov.db.mysql.extractor.DefaultExtractorUtil;
import ua.kh.baklanov.db.queries.Queries;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.PC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DefaultPCDAOImpl implements PCDAO {

    private DAOFactory factory;
    private static final Logger LOG = Logger.getLogger(DefaultPCDAOImpl.class);

    public DefaultPCDAOImpl()  {
        factory = DAOFactory.getDefaultFactory();
    }

    @Override
    public void insert(PC obj) throws DbException {

    }

    @Override
    public PC getById(long id) throws DbException {
        LOG.info(Messages.INFO_GET_BY_ID+PC.class.getSimpleName());
        PC pc=null;
        try (Connection con = factory.getConnection();
             PreparedStatement statement = con.prepareStatement(Queries.GET_PC_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    pc = DefaultExtractorUtil.extractPC(rs);
                }
            }
        } catch (SQLException | DbException ex) {
            LOG.error(Messages.ERROR_GET_BY_ID+PC.class.getSimpleName(), ex);
            throw new DbException(Messages.ERROR_GET_BY_ID+PC.class.getSimpleName(), ex);
        }
        return pc;
    }

    @Override
    public void update(PC obj) throws DbException {

    }

    @Override
    public void delete(long id) throws DbException {

    }

    @Override
    public List getAll() throws DbException {
        return null;
    }
}
