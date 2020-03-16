package ua.kh.baklanov.web.command.service;

import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.db.dao.TVDAO;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.service.DAOService;
import ua.kh.baklanov.service.DefaultService;
import ua.kh.baklanov.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TypesTVCommand extends Command {
    private static final Logger LOG = Logger.getLogger(TypesTVCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<String> tvTypes;
        DAOService service = new DefaultService();
        try {
            TVDAO tvDAO = service.getTVDao();
            tvTypes=tvDAO.getTypes();

        } catch (DbException e) {
            LOG.error(Messages.ERROR_TV_DAO + TypesTVCommand.class.getName(), e);
            return Route.PAGE_ERROR_PAGE;
        }
        request.setAttribute("tvTypes", tvTypes);
        return Route.TV_SERVICE;
    }
}
