package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffCreateCommand implements AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
        System.out.println("CREATE");
        return null;
    }
}
