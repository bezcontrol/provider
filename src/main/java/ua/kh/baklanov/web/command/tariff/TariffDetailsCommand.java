package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;

import ua.kh.baklanov.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffDetailsCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffDetailsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Route.ALL_TARIFFS_COM;
    }
}
