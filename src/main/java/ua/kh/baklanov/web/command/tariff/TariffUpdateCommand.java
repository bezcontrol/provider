package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.Tariff;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffUpdateCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(TariffUpdateCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        AnyTariff anyTariff=new AnyTariff();
        Tariff tariff=new Tariff();
        tariff.setId(Long.parseLong(request.getParameter(Parameters.TARIFF_ID)));
        tariff.setPrice(Integer.parseInt(request.getParameter(Parameters.TARIFF_PRICE)));
        tariff.setDurationInDays(Integer.parseInt(request.getParameter(Parameters.TARIFF_DURATION)));
        anyTariff.setTariff(tariff);
        return null;
    }
}
