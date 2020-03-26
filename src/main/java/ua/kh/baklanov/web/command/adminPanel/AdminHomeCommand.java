package ua.kh.baklanov.web.command.adminPanel;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.UserBeanDAO;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.UserBean;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminHomeCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(AdminHomeCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        try {
            DAOService service= new DefaultService();
            UserBeanDAO userDAO = service.getUserBeanDAO();
            List<UserBean> users=userDAO.getAll();
            request.getSession().setAttribute(Attributes.USERS, users);
            return Route.ADMIN_HOME;
        } catch (DbException e) {
            LOG.error(Messages.ERROR_USER_DAO + AdminHomeCommand.class.getName(), e);
            return Route.HOME;
        }
    }
}
