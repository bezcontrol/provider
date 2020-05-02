package ua.kh.baklanov.web.command;

import ua.kh.baklanov.exception.AppException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface AbstractCommand {

    String execute(HttpServletRequest request,
                                   HttpServletResponse response) throws AppException;

}
