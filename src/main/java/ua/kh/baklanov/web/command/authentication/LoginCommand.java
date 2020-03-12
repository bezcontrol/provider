package ua.kh.baklanov.web.command.authentication;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.DAOFactory;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        // obtain login and password from a request

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            throw new AppException("Login/password cannot be empty");
        }
        DAOFactory factory = DAOFactory.getMySQLDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getByLogin(login);

        if (user == null || !password.equals(user.getPassword())) {
            throw new AppException("Cannot find user with such login/password");
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
