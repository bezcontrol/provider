package ua.kh.baklanov.web.command.authentication;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return Route.LOGIN;
    }
}
