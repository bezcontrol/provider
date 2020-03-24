package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.model.entity.PC;
import ua.kh.baklanov.model.entity.TV;
import ua.kh.baklanov.model.entity.Tariff;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffCreateCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        Tariff tariff=new Tariff();
        DAOService service=new DefaultService();
        TariffDAO tariffDAO = service.getTariffDAO();
        tariff.setName(request.getParameter(Parameters.TARIFF_NAME));
        tariff.setPrice(Integer.parseInt(request.getParameter(Parameters.TARIFF_PRICE)));
        tariff.setDurationInDays(Integer.parseInt(request.getParameter(Parameters.TARIFF_DURATION)));
        if(request.getParameter(Parameters.SERVICE_TYPE).equals(PC.class.getSimpleName())){
            tariff.setIdService(Long.parseLong(request.getParameter(Parameters.SERVICE_ID_PC)));
        }else if(request.getParameter(Parameters.SERVICE_TYPE).equals(TV.class.getSimpleName())){
            tariff.setIdService(Long.parseLong(request.getParameter(Parameters.SERVICE_ID_TV)));
        } else {
            tariff.setIdService(Long.parseLong(request.getParameter(Parameters.SERVICE_ID_MOBILE)));
        }

        tariffDAO.insert(tariff);
        return Route.HOME;
    }
}
