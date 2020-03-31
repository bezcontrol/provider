package ua.kh.baklanov.service;

import ua.kh.baklanov.context.Attributes;
import ua.kh.baklanov.context.Context;
import ua.kh.baklanov.db.dao.*;
import ua.kh.baklanov.exception.DbException;

public class DefaultService implements DAOService {

    public UserDAO getUserDAO() {
        return (UserDAO) Context.get(Attributes.USER_DAO);
    }

    @Override
    public UserBeanDAO getUserBeanDAO() throws DbException {
        return (UserBeanDAO) Context.get(Attributes.USER_BEAN_DAO);
    }

    public TVDAO getTVDAO() throws DbException {
        return (TVDAO) Context.get(Attributes.TV_DAO);
    }

    public PCDAO getPCDAO() throws DbException {
        return (PCDAO) Context.get(Attributes.PC_DAO);
    }

    public AnyTariffDAO getAnyTariffDAO() throws DbException {
        return (AnyTariffDAO) Context.get(Attributes.ANY_TARIFF_DAO);
    }

    public ServiceDAO getServiceDAO() throws DbException {
        return (ServiceDAO) Context.get(Attributes.SERVICE_DAO);
    }

    public TariffDAO getTariffDAO() throws DbException {
        return (TariffDAO) Context.get(Attributes.TARIFF_DAO);
    }

    public InternetDAO getInternetDAO() throws DbException {
        return (InternetDAO) Context.get(Attributes.INTERNET_DAO);
    }

    public MobileDAO getMobileDAO() throws DbException {
        return (MobileDAO) Context.get(Attributes.MOBILE_DAO);
    }

    @Override
    public RoleDAO getRoleDAO() throws DbException {
        return (RoleDAO) Context.get(Attributes.ROLE_DAO);
    }

    @Override
    public StatusDAO getStatusDAO() throws DbException {
        return (StatusDAO) Context.get(Attributes.STATUS_DAO);
    }

    @Override
    public ContractDAO getContractDAO() throws DbException {
        return (ContractDAO) Context.get(Attributes.CONTRACT_DAO);
    }

    @Override
    public ContractStateDAO getContractStateDAO() throws DbException {
        return (ContractStateDAO) Context.get(Attributes.CONTRACT_STATE_DAO);
    }

    public AnyServiceDAO getAnyServiceDAO() {
        return (AnyServiceDAO) Context.get(Attributes.ANY_SERVICE_DAO);
    }
}
