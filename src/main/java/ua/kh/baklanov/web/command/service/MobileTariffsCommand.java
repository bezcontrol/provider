package ua.kh.baklanov.web.command.service;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MobileTariffsCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(MobileTariffsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        DAOService service = new DefaultService();
        List<AnyTariff> mobileTariffs;
        try {
            AnyTariffDAO anyTariffDAO = service.getAnyTariffDAO();
            mobileTariffs = anyTariffDAO.getAllMobileTariffs();
        } catch (DbException e) {
            LOG.error(Messages.ERROR_ANY_TARIFF_DAO + MobileTariffsCommand.class.getName(), e);
            return Route.ERROR_PAGE;
        }
        request.setAttribute("tariffs", mobileTariffs);
        return Route.TARIFFS;
    }
}
