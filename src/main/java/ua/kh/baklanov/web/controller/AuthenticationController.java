package ua.kh.baklanov.web.controller;


import org.apache.log4j.Logger;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.exception.Messages;
import ua.kh.baklanov.web.command.Command;
import ua.kh.baklanov.web.command.authentication.AuthenticationCommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/authentication")
public class AuthenticationController extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AuthenticationController.class);

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {
        process(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response){
        process(request, response);
    }

    private void process(HttpServletRequest request,
                             HttpServletResponse response) {

        String commandName = request.getParameter(Parameters.COMMAND);
        Command command = AuthenticationCommandContainer.get(commandName);
        String forward = Route.PAGE_ERROR_PAGE;
        try {
            LOG.info("Executing command");
            forward = command.execute(request, response);
        } catch (AppException ex) {
            LOG.error(Messages.ERROR_EXECUTING_COMMAND + command.getClass().getName(),ex);
            request.setAttribute(Attributes.ERROR, Messages.ERROR_EXECUTING_COMMAND);
        }
        if (Objects.nonNull(request.getAttribute(Attributes.ERROR)) ||
                Objects.nonNull(request.getAttribute(Attributes.ERROR_VALIDATION))) {
            try {
                request.getRequestDispatcher(forward).forward(request, response);
            } catch (ServletException | IOException e) {
                LOG.error(Messages.ERROR_FORWARD + AuthenticationController.class.getName(), e);
            }
        } else {
            try {
                response.sendRedirect(forward);
            } catch (IOException e) {
                LOG.error(Messages.ERROR_REDIRECT + AuthenticationController.class.getName(), e);
            }
        }
    }
}
