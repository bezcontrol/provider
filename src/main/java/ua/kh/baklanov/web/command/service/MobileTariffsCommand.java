package ua.kh.baklanov.web.command.service;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MobileTariffsCommand extends Command {
    private static final Logger LOG = Logger.getLogger(MobileTariffsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        DAOService service = new DefaultService();
        List<AnyTariff> mobileTariffs;
        try {
            TariffDAO tariffDAO = service.getTariffDao();
            mobileTariffs = tariffDAO.getAllMobileTariffs();
        } catch (DbException e) {
            LOG.error(Messages.ERROR_TARIFF_DAO + MobileTariffsCommand.class.getName(), e);
            return Route.PAGE_ERROR_PAGE;
        }
        request.setAttribute("tariffs", mobileTariffs);
        System.out.println(mobileTariffs.toString());
        return Route.TARIFFS;
    }
}
