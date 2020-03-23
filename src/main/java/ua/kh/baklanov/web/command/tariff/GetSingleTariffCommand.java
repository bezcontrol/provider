package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.AnyServiceDAO;
import ua.kh.baklanov.db.dao.InternetDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyService;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.Internet;
import ua.kh.baklanov.model.entity.Mobile;
import ua.kh.baklanov.model.entity.PC;
import ua.kh.baklanov.model.entity.TV;
import ua.kh.baklanov.service.BeanExtractorUtil;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetSingleTariffCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(GetSingleTariffCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.addHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        DAOService service = new DefaultService();
        long tariffId = Long.parseLong(request.getParameter(Parameters.TARIFF_ID));
        try {
            AnyTariff tariff = BeanExtractorUtil.extractAnyTariffById(tariffId);
            String operationName = request.getParameter(Parameters.OPERATION);
            request.setAttribute(Attributes.SELECTED_TARIFF, tariff);
            if("Update".equals(operationName)||"Create".equals(operationName)){
                AnyServiceDAO dao = service.getAnyServiceDAO();
                List<AnyService> servicesList;
                if(request.getParameter(Parameters.SERVICE_TYPE).equals(PC.class.getSimpleName())){
                    servicesList=dao.getCurrentPCTypedServices(
                            Long.parseLong(request.getParameter(
                                    Parameters.SERVICE_ID)));
                } else if (request.getParameter(Parameters.SERVICE_TYPE).equals(TV.class.getSimpleName())){
                    servicesList=dao.getCurrentTVTypedServices(
                            Long.parseLong(request.getParameter(
                                    Parameters.SERVICE_ID)));
                } else {
                     servicesList=dao.getCurrentMobileTypedServices(
                             Long.parseLong(request.getParameter(
                                     Parameters.SERVICE_ID)));
                }
                request.setAttribute("servicesList", servicesList);
            }
            request.setAttribute(Attributes.OPERATION, operationName);
            return Route.SINGLE_TARIFF;
        } catch (DbException e) {
            LOG.error(Messages.ERROR_BEAN_EXTRACTOR_UTIL + TariffUpdateCommand.class.getName(), e);
            return Route.PAGE_ERROR_PAGE;
        }
    }
}