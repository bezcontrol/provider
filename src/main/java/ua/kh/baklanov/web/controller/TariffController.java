package ua.kh.baklanov.web.controller;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.tariff.TariffCommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tariff")
public class TariffController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(TariffController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String commandName = req.getParameter(Parameters.COMMAND);
        AbstractCommand command = TariffCommandContainer.get(commandName);
        String forward = Route.PAGE_ERROR_PAGE;
        try {
            LOG.info(Messages.INFO_EXECUTING_COMMAND+commandName);
            forward = command.execute(req, resp);
        } catch (AppException ex) {
            LOG.error(Messages.ERROR_EXECUTING_COMMAND + command.getClass().getName(),ex);
        }
        try {
            req.getRequestDispatcher(forward).forward(req,resp);
        } catch (ServletException | IOException ex) {
            LOG.error(Messages.ERROR_FORWARD+TariffController.class.getName(),ex);
        }
    }
}