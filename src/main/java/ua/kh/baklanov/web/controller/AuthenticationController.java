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
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {
        try {
        if(request.getSession().getAttribute("user")!=null){
                request.getRequestDispatcher(Route.HOME).forward(request, response);
        }
        else {
            request.getRequestDispatcher(Route.LOGIN).forward(request,response);
        }
        }
        catch (ServletException | IOException e) {
            LOG.error(Messages.ERROR_FORWARD+ AuthenticationController.class.getName(),e);
            request.setAttribute("error", Messages.ERROR_FORWARD);
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        processPost(request, response);
    }

    /**
     * Main method of this controller.
     */
    private void processPost(HttpServletRequest request,
                         HttpServletResponse response) {

        String commandName = request.getParameter("command");
        Command command = AuthenticationCommandContainer.get(commandName);
        String forward = Route.PAGE_ERROR_PAGE;
        try {
            forward = command.execute(request, response);
        } catch (AppException ex) {
            LOG.error(Messages.ERROR_EXECUTING_COMMAND+ command.getClass().getName());
            request.setAttribute("error", Messages.ERROR_EXECUTING_COMMAND);
        }
        if(Objects.nonNull(request.getAttribute("error"))||Objects.nonNull(request.getAttribute("errorValidation"))){
            try {
                request.getRequestDispatcher(forward).forward(request,response);
            } catch (ServletException | IOException e) {
                LOG.error(Messages.ERROR_FORWARD + AuthenticationController.class.getName(), e);
                request.setAttribute("error", Messages.ERROR_FORWARD);
            }
        }
        else {
            try {
                response.sendRedirect(forward);
            } catch (IOException e) {
                LOG.error(Messages.ERROR_REDIRECT + AuthenticationController.class.getName(), e);
                request.setAttribute("error", Messages.ERROR_REDIRECT);
            }
        }
    }
}
