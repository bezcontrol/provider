package ua.kh.baklanov.web.command.service;

import org.apache.log4j.Logger;
import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AllTariffsCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(AllTariffsCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        DAOService service = new DefaultService();
        List allTariffs;
        try {
            AnyTariffDAO anyTariffDAO = service.getAnyTariffDAO();
            allTariffs = anyTariffDAO.getAll();
        } catch (DbException e) {
            LOG.error(Messages.ERROR_ANY_TARIFF_DAO + AllTariffsCommand.class.getName(), e);
            return Route.ERROR_PAGE;
        }
        request.setAttribute("tariffs", allTariffs);
        return Route.TARIFFS;
    }
}
