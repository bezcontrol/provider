package ua.kh.baklanov.service;

import ua.kh.baklanov.context.Attributes;
import ua.kh.baklanov.context.Context;
import ua.kh.baklanov.db.dao.AnyServiceDAO;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.db.dao.ContractBeanDAO;
import ua.kh.baklanov.db.dao.ContractDAO;
import ua.kh.baklanov.db.dao.ContractStateDAO;
import ua.kh.baklanov.db.dao.InternetDAO;
import ua.kh.baklanov.db.dao.MobileDAO;
import ua.kh.baklanov.db.dao.PCDAO;
import ua.kh.baklanov.db.dao.RoleDAO;
import ua.kh.baklanov.db.dao.ServiceDAO;
import ua.kh.baklanov.db.dao.StatusDAO;
import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.db.dao.UserBeanDAO;
import ua.kh.baklanov.db.dao.UserDAO;

/**
 * Class that contains methods for getting any dao from
 * @see Context
 * @author Aleksei Baklanov
 */
public class DefaultService implements DAOService {

    public UserDAO getUserDAO() {
        return (UserDAO) Context.get(Attributes.USER_DAO);
    }

    @Override
    public UserBeanDAO getUserBeanDAO() {
        return (UserBeanDAO) Context.get(Attributes.USER_BEAN_DAO);
    }

    public TVDAO getTVDAO() {
        return (TVDAO) Context.get(Attributes.TV_DAO);
    }

    public PCDAO getPCDAO() {
        return (PCDAO) Context.get(Attributes.PC_DAO);
    }

    public AnyTariffDAO getAnyTariffDAO() {
        return (AnyTariffDAO) Context.get(Attributes.ANY_TARIFF_DAO);
    }

    public ServiceDAO getServiceDAO() {
        return (ServiceDAO) Context.get(Attributes.SERVICE_DAO);
    }

    public TariffDAO getTariffDAO() {
        return (TariffDAO) Context.get(Attributes.TARIFF_DAO);
    }

    public InternetDAO getInternetDAO() {
        return (InternetDAO) Context.get(Attributes.INTERNET_DAO);
    }

    public MobileDAO getMobileDAO(){
        return (MobileDAO) Context.get(Attributes.MOBILE_DAO);
    }

    @Override
    public RoleDAO getRoleDAO() {
        return (RoleDAO) Context.get(Attributes.ROLE_DAO);
    }

    @Override
    public StatusDAO getStatusDAO() {
        return (StatusDAO) Context.get(Attributes.STATUS_DAO);
    }

    @Override
    public ContractDAO getContractDAO() {
        return (ContractDAO) Context.get(Attributes.CONTRACT_DAO);
    }

    @Override
    public ContractStateDAO getContractStateDAO() {
        return (ContractStateDAO) Context.get(Attributes.CONTRACT_STATE_DAO);
    }

    @Override
    public ContractBeanDAO getContractBeanDAO() {
        return (ContractBeanDAO) Context.get(Attributes.CONTRACT_BEAN_DAO);
    }

    public AnyServiceDAO getAnyServiceDAO() {
        return (AnyServiceDAO) Context.get(Attributes.ANY_SERVICE_DAO);
    }
}
