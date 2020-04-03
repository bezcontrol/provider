package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.ContractDAO;
import ua.kh.baklanov.db.dao.ContractStateDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.bean.UserBean;
import ua.kh.baklanov.model.entity.Contract;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

import java.time.LocalDateTime;
import java.util.List;

public class ContractRequestCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        Contract contract = new Contract();
        UserBean user= (UserBean) request.getSession().getAttribute(Attributes.USER);
        List<AnyTariff> cart= (List<AnyTariff>) request.getSession().getAttribute(Attributes.CART);
        DAOService daoService=new DefaultService();
        ContractDAO contractDAO=daoService.getContractDAO();
        ContractStateDAO contractStateDAO=daoService.getContractStateDAO();
        for (AnyTariff tariff:cart) {
            contract.setIdUser(user.getUser().getId());
            contract.setIdTariff(tariff.getTariff().getId());
            contract.setIdContractState(contractStateDAO.getStatusByName("waiting").getId());
            contract.setContractConclusionDate(LocalDateTime.now());
            contract.setContractExpirationDate(LocalDateTime.now().plusDays(tariff.getTariff().getDurationInDays()));
            contractDAO.insert(contract);
        }
        cart.clear();
        return Route.MY_CONTRACTS;
    }
}
