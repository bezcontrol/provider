package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.InternetDAO;
import ua.kh.baklanov.db.dao.MobileDAO;
import ua.kh.baklanov.db.dao.PCDAO;
import ua.kh.baklanov.db.dao.ServiceDAO;
import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.Service;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffDetailsAbstractCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffDetailsAbstractCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        long tariffId = Long.parseLong(request.getParameter(Parameters.TARIFF_ID));
        AnyTariff tariff = new AnyTariff();
        DAOService daoService = new DefaultService();
        try {
            ServiceDAO dao = daoService.getServiceDAO();
            TariffDAO tariffdao=daoService.getTariffDAO();
            InternetDAO internetdao=daoService.getInternetDAO();
            Service service = dao.getServiceByTariffId(tariffId);
            tariff.setTariff(tariffdao.getById(tariffId));
            tariff.setInternet(internetdao.getById(service.getIdInternet()));
            tariff.setService(getTypedObject(daoService,service));

        } catch (DbException e) {
            LOG.error(Messages.ERROR_SERVICE_DAO + TariffDetailsAbstractCommand.class.getName(), e);
            return Route.PAGE_ERROR_PAGE;
        }
        request.setAttribute("selectedTariff", tariff);
        return Route.SINGLE_TARIFF;
    }

    private static Object getTypedObject(DAOService daoService, Service service) throws DbException {
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
