package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffDeleteCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffDeleteCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        DAOService service=new DefaultService();
        try {
            TariffDAO tariffDAO = service.getTariffDAO();
            tariffDAO.delete(Long.parseLong(request.getParameter(Parameters.TARIFF_ID)));
        } catch (DbException e) {
            LOG.error(Messages.ERROR_TARIFF_DAO + TariffDeleteCommand.class.getName(), e);
            return Route.ERROR_PAGE;
        }
        return Route.ALL_TARIFFS;
    }
}
