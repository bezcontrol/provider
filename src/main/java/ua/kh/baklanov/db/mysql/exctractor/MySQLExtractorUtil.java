package ua.kh.baklanov.db.mysql.exctractor;

import org.apache.log4j.Logger;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLExtractorUtil {

    private MySQLExtractorUtil(){}

    private static final Logger LOG = Logger.getLogger(MySQLExtractorUtil.class);

    public static User extractUser(ResultSet rs) throws DbException {
        User user=new User();
        try {
            user.setId(rs.getLong("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setIdRole(rs.getLong("idRole"));
        } catch (SQLException ex) {
            LOG.error(Messages.ERROR_EXTRACTING+user.getClass().getName(), ex);
            throw new DbException(Messages.ERROR_OBTAIN_CONNECTION, ex);
        }
        return user;
    }
}