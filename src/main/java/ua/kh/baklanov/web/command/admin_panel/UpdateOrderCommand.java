package ua.kh.baklanov.web.command.admin_panel;

import ua.kh.baklanov.db.dao.ContractDAO;
import ua.kh.baklanov.db.dao.ContractStateDAO;
import ua.kh.baklanov.db.dao.StatusDAO;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.db.dao.UserDAO;
import ua.kh.baklanov.model.entity.Contract;
import ua.kh.baklanov.model.entity.ContractState;
import ua.kh.baklanov.model.entity.Status;
import ua.kh.baklanov.model.entity.Tariff;
import ua.kh.baklanov.model.entity.User;
import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOrderCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        DAOService service=new DefaultService();
        ContractDAO contractDAO=service.getContractDAO();
        Contract contract=contractDAO.getById(Long.parseLong(request.getParameter(Parameters.CONTRACT_ID)));
        ContractStateDAO contractStateDAO=service.getContractStateDAO();
        ContractState contractState=contractStateDAO.getStatusByName("registered");
        if(contractState.getId()==Long.parseLong(request.getParameter(Parameters.CONTRACT_STATE))){
            UserDAO userDAO=service.getUserDAO();
            TariffDAO tariffDAO=service.getTariffDAO();
            Tariff tariff=tariffDAO.getById(Long.parseLong(request.getParameter(Parameters.TARIFF_ID)));
            User user=userDAO.getById(Long.parseLong(request.getParameter(Parameters.USER_ID)));
            StatusDAO statusDAO=service.getStatusDAO();
            Status status=null;
            if(user.getBill()>=tariff.getPrice()){
                user.setBill(user.getBill()-tariff.getPrice());
                contract.setIdContractState(Long.parseLong(request.getParameter(Parameters.CONTRACT_STATE)));
                status = statusDAO.getStatusByName("registered");
            } else {
                status = statusDAO.getStatusByName("blocked");
            }
            user.setIdStatus(status.getId());
            userDAO.update(user);
        }
        contractDAO.update(contract);
        return Route.ADMIN_ORDERS_COM;
    }
}
