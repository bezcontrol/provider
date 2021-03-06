package ua.kh.baklanov.web.controller;

import org.apache.log4j.Logger;
import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.service.ServiceCommandContainer;
import ua.kh.baklanov.web.search.Sorter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/service")
public class ServiceController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ServiceController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        UserTrackerUtil.setCurrentStateOfUserFromDb(req.getSession());
        String commandName = req.getParameter(Parameters.COMMAND);
        AbstractCommand command = ServiceCommandContainer.get(commandName);
        String forward = Route.ERROR_PAGE;
        try {
            LOG.info(Messages.INFO_EXECUTING_COMMAND+command.getClass().getSimpleName());
            forward = command.execute(req, resp);
        } catch (AppException ex) {
            LOG.error(Messages.ERROR_EXECUTING_COMMAND + command.getClass().getSimpleName(),ex);
        }
        try {
            req.getSession().setAttribute(Attributes.SORT_OPERATIONS, Sorter.values());
            req.getRequestDispatcher(forward).forward(req,resp);
        } catch (ServletException |IOException ex) {
            LOG.error(Messages.ERROR_FORWARD+ServiceController.class.getSimpleName(),ex);
            try {
                req.getRequestDispatcher(Route.RECHARGE_BALANCE).forward(req,resp);
            } catch (ServletException | IOException e) {
                LOG.error(Messages.ERROR_FORWARD+ServiceController.class.getSimpleName(),ex);
            }
        }
    }
}
