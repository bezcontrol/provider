package ua.kh.baklanov.web.validation;

import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;

import java.util.Objects;

public class ValidateAuthentication {
    private ValidateAuthentication(){}

    public static String isUserAlreadyRegistered(User user) throws DbException {
        DAOService service= new DefaultService();
        UserDAO userDAO = service.getUserDao();
        User userFromDB;
        userFromDB=userDAO.getByEmail(user.getEmail());
        if(Objects.nonNull(userFromDB)){
            return "You have account with this email";
        }
        userFromDB=userDAO.getByLogin(user.getLogin());
        if(Objects.nonNull(userFromDB)){
            return "You have account with this login";
        }
        return null;
    }
}
