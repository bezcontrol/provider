package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.DbException;

import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Tariff;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffUpdateCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffUpdateCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        try {
            Tariff tariff=new Tariff();
            tariff.setId(Long.parseLong(request.getParameter(Parameters.TARIFF_ID)));
            tariff.setName(request.getParameter(Parameters.TARIFF_NAME));
            tariff.setPrice(Integer.parseInt(request.getParameter(Parameters.TARIFF_PRICE)));
            tariff.setDurationInDays(Integer.parseInt(request.getParameter(Parameters.TARIFF_DURATION)));
            tariff.setIdService(Long.parseLong(request.getParameter(Parameters.SERVICE_ID)));
            DAOService service=new DefaultService();
            TariffDAO tariffDAO = service.getTariffDAO();
            tariffDAO.update(tariff);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return Route.TARIFFS;
    }
}
