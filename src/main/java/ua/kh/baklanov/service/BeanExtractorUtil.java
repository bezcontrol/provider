package ua.kh.baklanov.service;

import ua.kh.baklanov.db.dao.*;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.Service;

public class BeanExtractorUtil {
    public static AnyTariff extractAnyTariffById(long tariffId) throws DbException {
        AnyTariff tariff = new AnyTariff();
        DAOService daoService = new DefaultService();
        ServiceDAO dao = daoService.getServiceDAO();
        TariffDAO tariffdao=daoService.getTariffDAO();
        InternetDAO internetdao=daoService.getInternetDAO();
        Service service = dao.getServiceByTariffId(tariffId);
        tariff.setTariff(tariffdao.getById(tariffId));
        tariff.setInternet(internetdao.getById(service.getIdInternet()));
        tariff.setService(getTypedObjectById(daoService,service));
        return tariff;
    }


    public static Object getTypedObjectById(DAOService daoService, Service service) throws DbException {
        if(service.getIdTV()!=0){
            TVDAO tvdao = daoService.getTVDAO();
            return tvdao.getById(service.getIdTV());
        } else if(service.getIdPC()!=0){
            PCDAO pcdao = daoService.getPCDAO();
            return pcdao.getById(service.getIdPC());
        } else {
            MobileDAO mobiledao= daoService.getMobileDAO();
            return mobiledao.getById(service.getIdMobile());
        }
    }
}
