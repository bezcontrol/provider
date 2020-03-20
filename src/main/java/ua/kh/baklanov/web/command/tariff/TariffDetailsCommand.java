package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.InternetDAO;
import ua.kh.baklanov.db.dao.MobileDAO;
import ua.kh.baklanov.db.dao.PCDAO;
import ua.kh.baklanov.db.dao.ServiceDAO;
import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.db.dao.TariffDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.Service;
import ua.kh.baklanov.service.BeanExtractorUtil;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffDetailsCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffDetailsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        long tariffId = Long.parseLong(request.getParameter(Parameters.TARIFF_ID));
        try {
          AnyTariff tariff = BeanExtractorUtil.extractAnyTariffById(tariffId);
          request.setAttribute("selectedTariff", tariff);
          return Route.SINGLE_TARIFF;
        } catch (DbException e) {
            LOG.error(Messages.ERROR_SERVICE_DAO + TariffDetailsCommand.class.getName(), e);
            return Route.PAGE_ERROR_PAGE;
        }
    }


}
