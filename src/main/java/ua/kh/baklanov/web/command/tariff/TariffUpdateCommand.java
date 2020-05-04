package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;

import ua.kh.baklanov.db.dao.ServiceDAO;
import ua.kh.baklanov.model.entity.*;
import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.DbException;

import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;
import ua.kh.baklanov.web.controller.Parameters;
import ua.kh.baklanov.web.validation.ValidateAnyTariffFields;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

public class TariffUpdateCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffUpdateCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        List<String> validateGeneral = ValidateAnyTariffFields.isGeneralFieldsValid(
                request.getParameter(Parameters.TARIFF_NAME),
                request.getParameter(Parameters.TARIFF_PRICE),
                request.getParameter(Parameters.TARIFF_DURATION));
        if (!validateGeneral.isEmpty()) {
            request.getSession().setAttribute(Attributes.ERROR_VALIDATION, validateGeneral);
            return "/tariff?"+Parameters.TARIFF_ID+"="+request.getParameter(Parameters.TARIFF_ID)+"&"+
                    Parameters.SERVICE_TYPE+"="+request.getParameter(Parameters.SERVICE_TYPE)+"&"+
                    Parameters.SERVICE_ID+"="+request.getParameter(Parameters.SERVICE_ID)+"&"+
                    Parameters.OPERATION+"="+"Update";
        } else {
            try {
                Tariff tariff = new Tariff();
                tariff.setId(Long.parseLong(request.getParameter(Parameters.TARIFF_ID)));
                tariff.setName(request.getParameter(Parameters.TARIFF_NAME));
                tariff.setPrice(Integer.parseInt(request.getParameter(Parameters.TARIFF_PRICE)));
                tariff.setDurationInDays(Integer.parseInt(request.getParameter(Parameters.TARIFF_DURATION)));
                isServicePC(request, tariff);
                isServiceTV(request, tariff);
                isServiceMobile(request, tariff);
                DAOService service = new DefaultService();
                TariffDAO tariffDAO = service.getTariffDAO();
                tariffDAO.update(tariff);
                return Route.ALL_TARIFFS_COM;
            } catch (DbException e) {
                LOG.error(Messages.ERROR_TARIFF_DAO + TariffUpdateCommand.class.getName(), e);
                return Route.ERROR_PAGE;
            }
        }

    }

    private static Tariff isServiceTV(HttpServletRequest request, Tariff tariff) {
        if (request.getParameter(Parameters.SERVICE_TYPE).equals(TV.class.getSimpleName())) {
            DAOService service = new DefaultService();
            try {
                ServiceDAO serviceDAO=service.getServiceDAO();
                Service serviceEntity;
                if(Objects.nonNull(request.getParameter(Parameters.INTERNET_ID)) &&
                        Long.parseLong(request.getParameter(Parameters.INTERNET_ID))!=0){
                    serviceEntity = serviceDAO.getTVServiceByIdAndInternetId(
                            Long.parseLong(request.getParameter(Parameters.SERVICE_ID)),
                            Long.parseLong(request.getParameter(Parameters.INTERNET_ID)));
                } else {
                    serviceEntity = serviceDAO.getTVServiceByIdAndWithoutInternet(
                            Long.parseLong(request.getParameter(Parameters.SERVICE_ID)));
                }

                tariff.setIdService(serviceEntity.getId());
            } catch (DbException e) {
                LOG.error(Messages.ERROR_SERVICE_DAO + TariffCreateCommand.class.getName(), e);
            }
        }
        return tariff;
    }

    private static Tariff isServiceMobile(HttpServletRequest request, Tariff tariff) {
        if (request.getParameter(Parameters.SERVICE_TYPE).equals(Mobile.class.getSimpleName())) {
            DAOService service = new DefaultService();
            try {
                ServiceDAO serviceDAO=service.getServiceDAO();
                Service serviceEntity;
                if(Objects.nonNull(request.getParameter(Parameters.INTERNET_ID)) &&
                        Long.parseLong(request.getParameter(Parameters.INTERNET_ID))!=0){
                    serviceEntity = serviceDAO.getMobileServiceByIdAndInternetId(
                            Long.parseLong(request.getParameter(Parameters.SERVICE_ID)),
                            Long.parseLong(request.getParameter(Parameters.INTERNET_ID)));
                } else {
                    serviceEntity = serviceDAO.getMobileServiceByIdAndWithoutInternet(
                            Long.parseLong(request.getParameter(Parameters.SERVICE_ID)));
                }
                tariff.setIdService(serviceEntity.getId());
            } catch (DbException e) {
                LOG.error(Messages.ERROR_SERVICE_DAO + TariffCreateCommand.class.getName(), e);
            }

        }
        return tariff;
    }

    private static Tariff isServicePC(HttpServletRequest request, Tariff tariff) {
        if (request.getParameter(Parameters.SERVICE_TYPE).equals(PC.class.getSimpleName())) {
            DAOService service = new DefaultService();
            try {
                ServiceDAO serviceDAO=service.getServiceDAO();
                Service serviceEntity;
                if(Objects.nonNull(request.getParameter(Parameters.INTERNET_ID)) &&
                        Long.parseLong(request.getParameter(Parameters.INTERNET_ID))!=0){
                    serviceEntity = serviceDAO.getPCServiceByIdAndInternetId(
                            Long.parseLong(request.getParameter(Parameters.SERVICE_ID)),
                            Long.parseLong(request.getParameter(Parameters.INTERNET_ID)));
                } else {
                    serviceEntity = serviceDAO.getPCServiceByIdAndWithoutInternet(
                            Long.parseLong(request.getParameter(Parameters.SERVICE_ID)));
                }
                tariff.setIdService(serviceEntity.getId());
            } catch (DbException e) {
                LOG.error(Messages.ERROR_SERVICE_DAO + TariffCreateCommand.class.getName(), e);
            }

        }
        return tariff;
    }
}
