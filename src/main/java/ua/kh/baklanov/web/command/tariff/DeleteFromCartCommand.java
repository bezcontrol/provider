package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Attributes;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteFromCartCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        long id = Long.parseLong(request.getParameter(Parameters.TARIFF_ID));
        List<AnyTariff> tariffs = (List<AnyTariff>) request.getSession().getAttribute(Attributes.CART);
        int forDelete = 0;
        for(int i=0;i<tariffs.size();i++){
            if(tariffs.get(i).getTariff().getId()==id){
                forDelete=i;
            }
        }
        tariffs.remove(forDelete);
        return Route.MY_CART;
    }
}
