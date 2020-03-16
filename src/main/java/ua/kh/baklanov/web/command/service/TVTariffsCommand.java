package ua.kh.baklanov.web.command.service;

import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TVTariffsCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        DAOService service = new DefaultService();
        TariffDAO tariffDAO = service.getTariffDao();


        return null;
    }
}
