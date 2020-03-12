package ua.kh.baklanov.web.command.authentication;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.MySQLService;
import ua.kh.baklanov.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            throw new AppException(Messages.ERROR_AUTHENTICATION_FORM);
        }
        DAOService service= new MySQLService();
        UserDAO userDAO = service.getUserDao();
        User user = userDAO.getByLogin(login);

        if (user == null || !password.equals(user.getPassword())) {
            throw new AppException(Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
        }

        Role userRole = Role.getRole(user);

        String forward = Route.PAGE_ERROR_PAGE;

        if (userRole == Role.ADMIN) {
            forward = Route.ADMIN_PANEL;
        }

        if (userRole == Role.CLIENT) {
            forward = Route.HOME;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return forward;
    }
}
