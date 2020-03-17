package ua.kh.baklanov.web.command.service;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AllTariffsCommand extends Command {
    private static final Logger LOG = Logger.getLogger(AllTariffsCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        DAOService service = new DefaultService();
        List allTariffs;
        try {
            AnyTariffDAO anyTariffDAO = service.getTariffDao();
            allTariffs = anyTariffDAO.getAll();
        } catch (DbException e) {
            LOG.error(Messages.ERROR_TARIFF_DAO + AllTariffsCommand.class.getName(), e);
            return Route.PAGE_ERROR_PAGE;
        }
        request.setAttribute("tariffs", allTariffs);
        return Route.TARIFFS;
    }
}
