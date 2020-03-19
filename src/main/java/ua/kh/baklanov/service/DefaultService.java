package ua.kh.baklanov.service;

import ua.kh.baklanov.context.Attributes;
import ua.kh.baklanov.context.Context;
import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.db.dao.UserDAO;

public class DefaultService implements DAOService {

    public UserDAO getUserDao() {
        return (UserDAO) Context.get(Attributes.USER_DAO);
    }

    public TVDAO getTVDao() {
        return (TVDAO) Context.get(Attributes.TV_DAO);
    }

    public AnyTariffDAO getAnyTariffDao() {
        return (AnyTariffDAO) Context.get(Attributes.ANY_TARIFF_DAO);
    }

    @Override
    public TariffDAO getTariffDao() {
        return (TariffDAO) Context.get(Attributes.TARIFF_DAO);
    }
}
