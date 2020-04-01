package ua.kh.baklanov.web.controller;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.UserBean;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.admin_panel.AdminCommandContainer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AdminController.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String commandName = req.getParameter(Parameters.OPERATION);
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
            LOG.error(Messages.ERROR_REDIRECT+ServiceController.class.getSimpleName(),ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            UserBean user= (UserBean) req.getSession().getAttribute("userBean");
            if (Objects.nonNull(user)&&"admin".equals(user.getRole().getName())) {
                String commandName = req.getParameter(Parameters.COMMAND);
                AbstractCommand command = AdminCommandContainer.get(commandName);
                String forward = Route.ERROR_PAGE;
                try {
                    LOG.info(Messages.INFO_EXECUTING_COMMAND + command.getClass().getSimpleName());
                    forward = command.execute(req, resp);
                } catch (AppException ex) {
                    LOG.error(Messages.ERROR_EXECUTING_COMMAND + command.getClass().getSimpleName(), ex);
                }
                resp.sendRedirect(forward);
            } else {
                resp.sendRedirect(Route.HOME);
            }
        } catch (IOException ex) {
            LOG.error(Messages.ERROR_REDIRECT + AdminController.class.getSimpleName(), ex);
        }
    }
}
