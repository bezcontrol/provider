package ua.kh.baklanov.web.command.admin_panel;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.ContractDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.model.entity.Contract;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class UpdateOrderCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        Contract contract=new Contract();
        contract.setId(Long.valueOf(request.getParameter(Parameters.CONTRACT_ID)));
        contract.setIdUser(Long.parseLong(request.getParameter(Parameters.USER_ID)));
        contract.setIdTariff(Long.parseLong(request.getParameter(Parameters.TARIFF_ID)));
        contract.setIdContractState(Long.parseLong(request.getParameter(Parameters.CONTRACT_STATE)));
        contract.setContractConclusionDate(LocalDateTime.parse(
                request.getParameter(Parameters.CONTRACT_CONCLUSION_DATE)));
        contract.setContractExpirationDate(LocalDateTime.parse(
                request.getParameter(Parameters.CONTRACT_EXPIRATION_DATE)));
        DAOService service=new DefaultService();
        ContractDAO contractDAO=service.getContractDAO();
        contractDAO.update(contract);
        return Route.ADMIN_ORDERS_COM;
    }
}
