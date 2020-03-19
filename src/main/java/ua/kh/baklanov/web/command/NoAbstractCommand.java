package ua.kh.baklanov.web.command;

import ua.kh.baklanov.Route;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoAbstractCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        return Route.PAGE_ERROR_PAGE;
    }
}
