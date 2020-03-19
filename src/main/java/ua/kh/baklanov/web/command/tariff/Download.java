package ua.kh.baklanov.web.command.tariff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Download {
    void load(HttpServletRequest request, HttpServletResponse response);
}
