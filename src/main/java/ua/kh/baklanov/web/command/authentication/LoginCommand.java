package ua.kh.baklanov.web.command.authentication;

import com.google.common.hash.Hashing;
import org.apache.commons.codec.Charsets;
import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.UserBeanDAO;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.UserBean;
import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.Status;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LoginCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            LOG.error(Messages.ERROR_FIELDS_NULL + LoginCommand.class.getName());
            return Route.ERROR_PAGE;
        }
        DAOService service = new DefaultService();
        String forward;
        try {
            UserBeanDAO userBeanDAO = service.getUserBeanDAO();
            UserBean user = userBeanDAO.getUserBeanByLogin(login);
            if (user == null ||
                    !Hashing.sha256().hashString(password, Charsets.UTF_8).toString()
                            .equals(user.getUser().getPassword())) {
                user = userBeanDAO.getByEmail(login);
                if (user == null || !password.equals(user.getUser().getPassword())) {
                    LOG.info(Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
                    request.setAttribute(Attributes.ERROR, Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
                    return Route.LOGIN;
                }
            }
            LOG.info("User was found");
            forward = getUserAccess(user, request);
        } catch (DbException e) {
            LOG.error(Messages.ERROR_USER_DAO + LoginCommand.class.getName(), e);
            forward = Route.ERROR_PAGE;
        }
        return forward;
    }


    private static String getUserAccess(UserBean user, HttpServletRequest request) {
        String forward = Route.ERROR_PAGE;
        if (Objects.nonNull(user.getRole())) {
            if ("waiting".equals(user.getStatus().getName())) {
                forward = Route.LOGIN;
                request.setAttribute(Attributes.ERROR, Messages.ERROR_ACCESS_WAITING);
                LOG.info(Messages.ERROR_ACCESS_WAITING);
            } else if ("missed".equals(user.getStatus().getName())) {
                forward = Route.LOGIN;
                request.setAttribute(Attributes.ERROR, Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
                LOG.error(Messages.ERROR_FIND_USER_WITH_THIS_CREDENTIALS);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute(Attributes.USER, user);
                forward = Route.HOME;
            }
        }
        return forward;
    }
}
