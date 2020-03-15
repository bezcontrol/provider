package ua.kh.baklanov.web.command.authentication;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.Status;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.Command;
import ua.kh.baklanov.web.controller.Attributes;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends Command {
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            LOG.error(Messages.FIELDS_NULL + LoginCommand.class.getName());
            return Route.PAGE_ERROR_PAGE;
        }
        DAOService service = new DefaultService();
        String forward;
        try {
            UserDAO userDAO = service.getUserDao();
            User user = userDAO.getByLogin(login);
            if (user == null || !password.equals(user.getPassword())) {
                user = userDAO.getByEmail(login);
                if (user == null || !password.equals(user.getPassword())) {
                    LOG.info(Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
                    request.setAttribute(Attributes.ERROR, Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
                    return Route.LOGIN;
                }
            }
            LOG.info("User was found");
            forward = getStatusOfUser(user, request);
        } catch (DbException e) {
            LOG.error(Messages.ERROR_USER_DAO + LoginCommand.class.getName(), e);
            forward = Route.PAGE_ERROR_PAGE;
        }
        return forward;
    }


    private static String getStatusOfUser(User user, HttpServletRequest request) {
        Role userRole = Role.getRole(user);
        String forward = Route.PAGE_ERROR_PAGE;
        if (Role.exist(userRole)) {
            if (Status.getStatus(user) == Status.WAITING) {
                forward = Route.LOGIN;
                request.setAttribute(Attributes.ERROR, Messages.ERROR_ACCESS_WAITING);
                LOG.info(Messages.ERROR_ACCESS_WAITING);
            } else if (Status.getStatus(user) == Status.MISSED) {
                forward = Route.LOGIN;
                request.setAttribute(Attributes.ERROR, Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
                LOG.error(Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute(Attributes.USER, user);
                session.setAttribute(Attributes.USER_ROLE, userRole);
                forward = Route.HOME;
            }
        }
        return forward;
    }
}
