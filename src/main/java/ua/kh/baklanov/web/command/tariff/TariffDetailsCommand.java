package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;

import ua.kh.baklanov.service.BeanExtractorUtil;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffDetailsCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffDetailsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("DETAILS");
//        long tariffId = Long.parseLong(request.getParameter(Parameters.TARIFF_ID));
//        try {
//          AnyTariff tariff = BeanExtractorUtil.extractAnyTariffById(tariffId);
//          request.setAttribute("selectedTariff", tariff);
//          request.setAttribute("command", "Details");
//          return Route.SINGLE_TARIFF;
//        } catch (DbException e) {
//            LOG.error(Messages.ERROR_BEAN_EXTRACTOR_UTIL + TariffDetailsCommand.class.getName(), e);
//            return Route.PAGE_ERROR_PAGE;
//        }
        return null;
    }
}
