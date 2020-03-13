package ua.kh.baklanov.web.command.authentication;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends Command {
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            throw new AppException(Messages.ERROR_AUTHENTICATION_FORM);
        }
        DAOService service= new DefaultService();
        UserDAO userDAO = service.getUserDao();
        User user = userDAO.getByLogin(login);
        String forward;
        if (user == null || !password.equals(user.getPassword())) {
            user=userDAO.getByEmail(login);
            if(user==null || !password.equals(user.getPassword())){
                LOG.error(Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
                request.setAttribute("error", Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
                forward=Route.LOGIN;
                return forward;
            }
        }

        Role userRole = Role.getRole(user);
        forward=Route.PAGE_ERROR_PAGE;
        if(Role.exist(userRole)){
            forward = Route.HOME;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("userRole", userRole);
        return forward;
    }
}
