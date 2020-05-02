package ua.kh.baklanov.web.controller;

import org.apache.log4j.Logger;
import ua.kh.baklanov.db.dao.UserBeanDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.UserBean;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Class that updates state of user every request
 * @author Aleksei Baklanov
 */
public final class UserTrackerUtil {
    private static final Logger LOG = Logger.getLogger(UserTrackerUtil.class);

    private UserTrackerUtil(){}

    public static void setCurrentStateOfUserFromDb(HttpSession session){
        try {
            UserBean userBean= (UserBean) session.getAttribute(Attributes.USER);
            if(Objects.nonNull(userBean)){
                DAOService service=new DefaultService();
                UserBeanDAO userBeanDAO = service.getUserBeanDAO();
                userBean=userBeanDAO.getByLogin(userBean.getUser().getLogin());
                session.setAttribute(Attributes.USER, userBean);
            }
        } catch (DbException e) {
            LOG.error(Messages.ERROR_SUPPORTING_USER_IN_ACTUAL_STATE + UserTrackerUtil.class.getSimpleName(), e);
        }
    }
}
