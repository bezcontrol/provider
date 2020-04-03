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
import java.util.Objects;

@WebServlet("/tariff")
public class TariffController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(TariffController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        AbstractCommand command = null;
        String forward = Route.ERROR_PAGE;
        try {
            String operation = req.getParameter(Parameters.OPERATION);
            if (Objects.nonNull(operation)) {
                command = TariffCommandContainer.get("getSingleTariff");
            } else {
                command = TariffCommandContainer.get(req.getParameter(Parameters.COMMAND));
            }
            LOG.info(Messages.INFO_EXECUTING_COMMAND + command.getClass().getSimpleName());
            forward = command.execute(req, resp);
        } catch (AppException ex) {
            LOG.error(Messages.ERROR_EXECUTING_COMMAND + command.getClass().getSimpleName(), ex);
        }
        try {
            req.getRequestDispatcher(forward).forward(req, resp);
        } catch (IOException | ServletException ex) {
            LOG.error(Messages.ERROR_FORWARD + TariffController.class.getSimpleName(), ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String commandName = req.getParameter(Parameters.COMMAND);
        AbstractCommand command = null;
        String forward = Route.ERROR_PAGE;
        try {
            command = TariffCommandContainer.get(commandName);
            LOG.info(Messages.INFO_EXECUTING_COMMAND + command.getClass().getSimpleName());
            forward = command.execute(req, resp);
        } catch (AppException ex) {
            LOG.error(Messages.ERROR_EXECUTING_COMMAND + command.getClass().getSimpleName(), ex);
        }
        try {
            resp.sendRedirect(forward);
        } catch (IOException ex) {
            LOG.error(Messages.ERROR_REDIRECT + TariffController.class.getSimpleName(), ex);
        }
    }
}