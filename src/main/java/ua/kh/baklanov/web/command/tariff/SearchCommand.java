package ua.kh.baklanov.web.command.tariff;

import org.apache.log4j.Logger;
import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.db.dao.AnyTariffDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.model.bean.AnyTariff;

import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.search.Sorter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchCommand implements AbstractCommand {
    private static final Logger LOG = Logger.getLogger(SearchCommand.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<AnyTariff> tariffs;
        try {
            DAOService service=new DefaultService();
            AnyTariffDAO anyTariffDAO = service.getAnyTariffDAO();
            tariffs=anyTariffDAO.getAll();
            tariffs=search(request,tariffs);
            tariffs=sort(request,tariffs);
        } catch (DbException e) {
            LOG.error(Messages.ERROR_ANY_TARIFF_DAO + SearchCommand.class.getName(), e);
            return Route.ERROR_PAGE;
        }
        request.setAttribute("tariffs", tariffs);
        return Route.TARIFFS;
    }


    private static List<AnyTariff> search(HttpServletRequest request, List<AnyTariff> tariffs){
        int lowerPrice= Integer.parseInt(request.getParameter("lowerPrice"));
        int upperPrice= Integer.parseInt(request.getParameter("upperPrice"));
        tariffs=tariffs.stream()
                .filter(o -> o.getTariff().getPrice() >= lowerPrice)
                .filter(o -> o.getTariff().getPrice() <= upperPrice).collect(Collectors.toList());
        return tariffs;
    }

    private static List<AnyTariff> sort(HttpServletRequest request, List<AnyTariff> tariffs) {
        Sorter operation= Sorter.getSorter(request.getParameter("select_search"));
        if(operation==Sorter.PRICE_ASCENDING){
            tariffs=tariffs.stream()
                    .sorted(Comparator.comparingInt(o -> o.getTariff().getPrice()))
                    .collect(Collectors.toList());
        } else if(operation==Sorter.PRICE_DESCENDING){
            tariffs=tariffs.stream()
                    .sorted((o1, o2) -> o2.getTariff().getPrice()-o1.getTariff().getPrice())
                    .collect(Collectors.toList());
        } else if(operation==Sorter.NAME_ASCENDING){
            tariffs=tariffs.stream()
                    .sorted((o1, o2) -> o2.getTariff().getName().compareTo(o1.getTariff().getName()))
                    .collect(Collectors.toList());
        } else {
            tariffs=tariffs.stream()
                    .sorted(Comparator.comparing(o -> o.getTariff().getName()))
                    .collect(Collectors.toList());
        }
        return tariffs;
    }

}
