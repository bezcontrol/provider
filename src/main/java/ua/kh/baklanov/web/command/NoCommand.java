package ua.kh.baklanov.web.command;

import ua.kh.baklanov.web.Route;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        return Route.ERROR_PAGE;
    }
}
