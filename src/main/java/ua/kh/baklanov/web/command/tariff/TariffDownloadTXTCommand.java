package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.Route;
import ua.kh.baklanov.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TariffDownloadTXTCommand implements AbstractCommand, Download {
    private static final int ARBITRARY_SIZE = 1048;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        load(request,response);
        return Route.TARIFFS;
    }

    @Override
    public void load(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename=sample.txt");

        try(InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/sample.txt");
            OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[ARBITRARY_SIZE];

            int numBytesRead;
            out.write("asdasdasd".getBytes());
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
