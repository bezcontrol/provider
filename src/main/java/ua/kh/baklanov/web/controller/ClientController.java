package ua.kh.baklanov.web.controller;

import org.apache.log4j.Logger;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.client_panel.ClientCommandContainer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/client")
public class ClientController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ClientController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        UserTrackerUtil.setCurrentStateOfUserFromDb(req.getSession());
        String commandName = req.getParameter(Parameters.COMMAND);
        AbstractCommand command = null;
        String forward = Route.ERROR_PAGE;
        try {
            command = ClientCommandContainer.get(commandName);
            LOG.info(Messages.INFO_EXECUTING_COMMAND + command.getClass().getSimpleName());
            forward = command.execute(req, resp);
        } catch (AppException ex) {
            LOG.error(Messages.ERROR_EXECUTING_COMMAND + command.getClass().getSimpleName(), ex);
        }
        try {
            resp.sendRedirect(forward);
        } catch (IOException ex) {
            LOG.error(Messages.ERROR_REDIRECT+ServiceController.class.getSimpleName(),ex);
        }
    }
}

