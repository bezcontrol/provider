package ua.kh.baklanov.web.command.adminPanel;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.RoleDAO;
import ua.kh.baklanov.db.dao.StatusDAO;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.Status;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(UpdateUserCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("updating");
        DAOService service=new DefaultService();
        try {
            UserDAO userDAO = service.getUserDAO();
            User user=new User();
            user.setIdRole(Long.parseLong(request.getParameter(Parameters.ROLE_USER)));
            user.setIdStatus(Long.parseLong(request.getParameter(Parameters.STATUS_USER)));
            user.setLogin(request.getParameter(Parameters.LOGIN));
            user.setEmail(request.getParameter(Parameters.EMAIL));
            String bill=request.getParameter(Parameters.BILL);
            user.setBill(Double.parseDouble(request.getParameter(Parameters.BILL)));
            userDAO.update(user);
        } catch (DbException e) {
            LOG.error(Messages.ERROR_USER_DAO + UpdateUserCommand.class.getName(), e);
            return Route.ERROR_PAGE;
        }

        return "/admin?command=home";
    }
}
