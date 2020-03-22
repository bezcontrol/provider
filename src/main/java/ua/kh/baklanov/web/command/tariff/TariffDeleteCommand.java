package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffDeleteCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("DELETE");
        return null;
    }
}
