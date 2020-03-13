package ua.kh.baklanov.web.command;

import ua.kh.baklanov.exception.AppException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Command {


    public abstract String execute(HttpServletRequest request,
                                   HttpServletResponse response) throws AppException;

}
