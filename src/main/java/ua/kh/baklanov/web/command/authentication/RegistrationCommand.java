package ua.kh.baklanov.web.command.authentication;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.model.entity.UserStatus;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.Command;
import ua.kh.baklanov.web.validation.ValidateAuthentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class RegistrationCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DbException {
        User user=new User();
        user.setLogin(request.getParameter("login"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setIdRole(Role.CLIENT.getValue());
        user.setIdStatus(UserStatus.WAITING.getValue());
        DAOService service= new DefaultService();
        UserDAO userDAO = service.getUserDao();
        String errorValidation= ValidateAuthentication.isUserAlreadyRegistered(user);
        String forward=Route.REGISTRATION;
        if(Objects.isNull(errorValidation)){
            userDAO.insert(user);
            forward=Route.LOGIN;
        }
        request.setAttribute("errorValidation",errorValidation);
        return forward;
    }
}
