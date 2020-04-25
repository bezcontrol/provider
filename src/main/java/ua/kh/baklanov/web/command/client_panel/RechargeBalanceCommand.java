package ua.kh.baklanov.web.command.client_panel;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.admin_panel.UpdateUserCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RechargeBalanceCommand implements AbstractCommand {

    private static final Logger LOG = Logger.getLogger(RechargeBalanceCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        DAOService service=new DefaultService();
        try {
            UserDAO userDAO = service.getUserDAO();
            User user=userDAO.getByLogin(request.getParameter(Parameters.LOGIN));
            user.setBill(user.getBill()+Long.parseLong(request.getParameter(Parameters.BILL)));
            userDAO.update(user);
        } catch (DbException e) {
            LOG.error(Messages.ERROR_USER_DAO + UpdateUserCommand.class.getName(), e);
            return Route.ERROR_PAGE;
        }
        return Route.ALL_TARIFFS_COM;
    }
}
