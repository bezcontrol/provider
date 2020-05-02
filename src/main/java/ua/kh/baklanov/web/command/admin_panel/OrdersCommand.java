package ua.kh.baklanov.web.command.admin_panel;

import org.apache.log4j.Logger;
import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.db.dao.ContractBeanDAO;
import ua.kh.baklanov.db.dao.ContractStateDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.ContractBean;
import ua.kh.baklanov.model.entity.ContractState;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrdersCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(OrdersCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            DAOService service= new DefaultService();
            ContractBeanDAO contractBeanDAO = service.getContractBeanDAO();
            List<ContractBean> contracts=contractBeanDAO.getAll();
            ContractStateDAO contractStateDAO = service.getContractStateDAO();
            List<ContractState> states=contractStateDAO.getAll();
            request.getSession().setAttribute(Attributes.CONTRACTS, contracts);
            request.getSession().setAttribute(Attributes.CONTRACT_STATES, states);
            return Route.ADMIN_ORDERS;
        } catch (DbException e) {
            LOG.error(Messages.ERROR_EXECUTING_COMMAND + OrdersCommand.class.getName(), e);
            return Route.HOME;
        }
    }
}
