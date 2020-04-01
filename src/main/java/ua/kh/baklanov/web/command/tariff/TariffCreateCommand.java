package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.entity.Mobile;
import ua.kh.baklanov.model.entity.PC;
import ua.kh.baklanov.model.entity.TV;
import ua.kh.baklanov.model.entity.Tariff;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;
import ua.kh.baklanov.web.controller.Parameters;
import ua.kh.baklanov.web.validation.ValidateAnyTariffFields;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TariffCreateCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffCreateCommand.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Tariff tariff = new Tariff();
        DAOService service = new DefaultService();
        TariffDAO tariffDAO;

        List<String> validateGeneral = ValidateAnyTariffFields.isGeneralFieldsValid(
                request.getParameter(Parameters.TARIFF_NAME),
                request.getParameter(Parameters.TARIFF_PRICE),
                request.getParameter(Parameters.TARIFF_DURATION));
        if (!validateGeneral.isEmpty()) {
            request.getSession().setAttribute(Attributes.ERROR_VALIDATION, validateGeneral);
            return "/tariff?operation=Create";
        } else {
            try {
                tariffDAO = service.getTariffDAO();
                tariff.setName(request.getParameter(Parameters.TARIFF_NAME));
                tariff.setPrice(Integer.parseInt(request.getParameter(Parameters.TARIFF_PRICE)));
                tariff.setDurationInDays(Integer.parseInt(request.getParameter(Parameters.TARIFF_DURATION)));
                isServicePC(request, tariff);
                isServiceTV(request, tariff);
                isServiceMobile(request, tariff);
                tariffDAO.insert(tariff);
                return Route.ALL_TARIFFS_COM;
            } catch (DbException e) {
                LOG.error(Messages.ERROR_TARIFF_DAO + TariffCreateCommand.class.getName(), e);
                return Route.ERROR_PAGE;
            }
        }
    }

    private static Tariff isServiceTV(HttpServletRequest request, Tariff tariff) {
        if (request.getParameter(Parameters.SERVICE_TYPE).equals(TV.class.getSimpleName())) {
            tariff.setIdService(Long.parseLong(request.getParameter(Parameters.SERVICE_ID_TV)));
        }
        return tariff;
    }

    private static Tariff isServiceMobile(HttpServletRequest request, Tariff tariff) {
        if (request.getParameter(Parameters.SERVICE_TYPE).equals(Mobile.class.getSimpleName())) {
            tariff.setIdService(Long.parseLong(request.getParameter(Parameters.SERVICE_ID_MOBILE)));
        }
        return tariff;
    }

    private static Tariff isServicePC(HttpServletRequest request, Tariff tariff) {
        if (request.getParameter(Parameters.SERVICE_TYPE).equals(PC.class.getSimpleName())) {
            tariff.setIdService(Long.parseLong(request.getParameter(Parameters.SERVICE_ID_PC)));
        }
        return tariff;
    }
}
