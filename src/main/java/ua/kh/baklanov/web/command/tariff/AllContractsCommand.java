package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.db.dao.ContractBeanDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.model.bean.ContractBean;
import ua.kh.baklanov.model.bean.UserBean;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AllContractsCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        DAOService service=new DefaultService();
        UserBean userBean= (UserBean) request.getSession().getAttribute(Attributes.USER);
        ContractBeanDAO contractBeanDAO = service.getContractBeanDAO();
        List<ContractBean> contracts = contractBeanDAO.getContractBeansByUserId(userBean.getUser().getId());
        request.getSession().setAttribute(Attributes.CONTRACTS, contracts);
        return Route.MY_CABINET;
    }
}
