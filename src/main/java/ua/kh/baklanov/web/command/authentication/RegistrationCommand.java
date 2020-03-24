package ua.kh.baklanov.web.command.authentication;

import com.google.common.hash.Hashing;
import org.apache.commons.codec.Charsets;
import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.model.entity.Status;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;
import ua.kh.baklanov.web.controller.Parameters;
import ua.kh.baklanov.web.validation.ValidateAuthentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class RegistrationCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(RegistrationCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        User user=new User();
        user.setLogin(request.getParameter(Parameters.LOGIN));
        user.setEmail(request.getParameter(Parameters.EMAIL));
        user.setPassword(Hashing.sha256()
                .hashString(request.getParameter(Parameters.PASSWORD), Charsets.UTF_8).toString());
        user.setIdRole(Role.CLIENT.getValue());
        user.setIdStatus(Status.WAITING.getValue());
        DAOService service= new DefaultService();
        String forward = Route.REGISTRATION;
        try {
            UserDAO userDAO = service.getUserDAO();
            String errorValidation = ValidateAuthentication.isUserAlreadyRegistered(user);
            if (Objects.isNull(errorValidation)) {
                userDAO.insert(user);
                forward = Route.LOGIN;
            }
            request.setAttribute(Attributes.ERROR_VALIDATION, errorValidation);
        } catch (DbException e) {
            LOG.error(Messages.ERROR_USER_DAO+ RegistrationCommand.class.getName(),e);
            forward=Route.ERROR_PAGE;
        }
        return forward;
    }
}
