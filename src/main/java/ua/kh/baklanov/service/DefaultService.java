package ua.kh.baklanov.service;

import ua.kh.baklanov.context.Attributes;
import ua.kh.baklanov.context.Context;
import ua.kh.baklanov.db.dao.*;

public class DefaultService implements DAOService {

    public UserDAO getUserDAO() {
        return (UserDAO) Context.get(Attributes.USER_DAO);
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

    public MobileDAO getMobileDAO() {
        return (MobileDAO) Context.get(Attributes.MOBILE_DAO);
    }

    public AnyServiceDAO getAnyServiceDAO(){return (AnyServiceDAO) Context.get(Attributes.ANY_SERVICE_DAO);}
}
