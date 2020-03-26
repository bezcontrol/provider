package ua.kh.baklanov.web.controller;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.adminPanel.AdminCommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AdminController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String commandName = req.getParameter(Parameters.COMMAND);
        AbstractCommand command = AdminCommandContainer.get(commandName);
        String forward = Route.ERROR_PAGE;
        try {
            LOG.info(Messages.INFO_EXECUTING_COMMAND+command.getClass().getSimpleName());
            forward = command.execute(req, resp);
        } catch (AppException ex) {
            LOG.error(Messages.ERROR_EXECUTING_COMMAND + command.getClass().getSimpleName(),ex);
        }
        try {
            resp.sendRedirect(forward);
        } catch (IOException ex) {
            LOG.error(Messages.ERROR_FORWARD+AdminController.class.getSimpleName(),ex);
        }
    }
}
