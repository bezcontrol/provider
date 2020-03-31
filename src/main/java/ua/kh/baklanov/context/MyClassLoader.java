package ua.kh.baklanov.context;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.mysql.DefaultFactory;
import ua.kh.baklanov.db.mysql.repository.*;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;

public final class MyClassLoader {
    private static final Logger LOG = Logger.getLogger(MyClassLoader.class);

    private MyClassLoader() {
    }

    public static void load() throws AppException {
        LOG.info(Messages.INFO_CLASS_LOADER_START);
        try {
            Context.put(Attributes.DB_FACTORY, DefaultFactory.getInstance());
            Context.put(Attributes.USER_DAO, new DefaultUserDAOImpl());
            Context.put(Attributes.TARIFF_DAO, new DefaultTariffDAOImpl());
            Context.put(Attributes.ANY_TARIFF_DAO, new DefaultAnyTariffDAOImpl());
            Context.put(Attributes.ANY_SERVICE_DAO, new DefaultAnyServiceDAOImpl());
            Context.put(Attributes.TV_DAO, new DefaultTVDAOImpl());
            Context.put(Attributes.PC_DAO, new DefaultPCDAOImpl());
            Context.put(Attributes.SERVICE_DAO, new DefaultServiceDAOImpl());
            Context.put(Attributes.INTERNET_DAO, new DefaultInternetDAOImpl());
            Context.put(Attributes.MOBILE_DAO, new DefaultMobileDAOImpl());
            Context.put(Attributes.USER_BEAN_DAO, new DefaultUserBeanDAOImpl());
            Context.put(Attributes.ROLE_DAO, new DefaultRoleDAOImpl());
            Context.put(Attributes.STATUS_DAO, new DefaultStatusDAOImpl());
            Context.put(Attributes.CONTRACT_DAO, new DefaultContractDAOImpl());
            Context.put(Attributes.CONTRACT_STATE_DAO, new DefaultContractStateDAOImpl());
        } catch (DbException e) {
            LOG.error(Messages.ERROR_CLASS_LOADER, e);
            throw new AppException(Messages.ERROR_CLASS_LOADER, e);
        }
        LOG.info(Messages.INFO_CLASS_LOADER_SUCCESS);
    }

}
