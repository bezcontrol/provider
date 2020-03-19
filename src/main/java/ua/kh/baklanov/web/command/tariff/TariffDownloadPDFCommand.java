package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffDownloadPDFCommand implements AbstractCommand, Download {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        load(request,response);
        return Route.TARIFFS;
    }

    @Override
    public void load(HttpServletRequest request, HttpServletResponse response) {
    }
}
