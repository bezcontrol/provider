package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.DbException;

import ua.kh.baklanov.exception.Messages;
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

public class TariffUpdateCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffUpdateCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        List<String> validateGeneral= ValidateAnyTariffFields.isGeneralFieldsValid(
                request.getParameter(Parameters.TARIFF_NAME),
                request.getParameter(Parameters.TARIFF_PRICE),
                request.getParameter(Parameters.TARIFF_DURATION));
        if(!validateGeneral.isEmpty()){
            request.getSession().setAttribute(Attributes.ERROR_VALIDATION,validateGeneral);
            return "/tariff?operation=Update";
        } else {
            try {
                Tariff tariff = new Tariff();
                tariff.setId(Long.parseLong(request.getParameter(Parameters.TARIFF_ID)));
                tariff.setName(request.getParameter(Parameters.TARIFF_NAME));
                tariff.setPrice(Integer.parseInt(request.getParameter(Parameters.TARIFF_PRICE)));
                tariff.setDurationInDays(Integer.parseInt(request.getParameter(Parameters.TARIFF_DURATION)));
                tariff.setIdService(Long.parseLong(request.getParameter(Parameters.SERVICE_ID)));
                DAOService service = new DefaultService();
                TariffDAO tariffDAO = service.getTariffDAO();
                tariffDAO.update(tariff);
                return Route.ALL_TARIFFS;
            } catch (DbException e) {
                LOG.error(Messages.ERROR_TARIFF_DAO + TariffUpdateCommand.class.getName(), e);
                return Route.ERROR_PAGE;
            }
        }
    }
}
