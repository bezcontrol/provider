package ua.kh.baklanov.web.command.service;

import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.model.entity.Tariff;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.Command;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TariffsCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        String typeOfService=request.getParameter(Parameters.TYPE_OF_SERVICE);
        DAOService service = new DefaultService();
        TariffDAO tariffDAO = service.getTariffDao();


        return null;
    }
}
