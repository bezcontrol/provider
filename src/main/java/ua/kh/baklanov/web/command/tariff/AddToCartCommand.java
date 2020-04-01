package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.service.BeanExtractorUtil;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddToCartCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        long tariffId = Long.parseLong(request.getParameter(Parameters.TARIFF_ID));
        AnyTariff tariff = BeanExtractorUtil.extractAnyTariffById(tariffId);
        List<AnyTariff> cart=(ArrayList<AnyTariff>)request.getSession().getAttribute(Attributes.CART);
        cart.add(tariff);
        return Route.ALL_TARIFFS_COM;
    }
}
