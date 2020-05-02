package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.web.Route;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.Mobile;
import ua.kh.baklanov.model.entity.PC;
import ua.kh.baklanov.model.entity.TV;
import ua.kh.baklanov.service.BeanExtractorUtil;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;
import ua.kh.baklanov.web.controller.TextFields;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

public class TariffDownloadTXTCommand implements AbstractCommand, Download {
    private static final int ARBITRARY_SIZE = 1048;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        load(request, response);
        return Route.TARIFFS;
    }

    @Override
    public void load(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename=sample.txt");

        try (InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/sample.txt");
             OutputStream out = response.getOutputStream()) {
            TextFields fields = (TextFields) request.getServletContext().getAttribute("textFields");
            long tariffId = Long.parseLong(request.getParameter(Parameters.TARIFF_ID));
            AnyTariff tariff = BeanExtractorUtil.extractAnyTariffById(tariffId);
            byte[] buffer = new byte[ARBITRARY_SIZE];

            int numBytesRead;
            out.write((fields.getTariffName() + tariff.getTariff().getName() + System.lineSeparator()).getBytes());
            out.write((fields.getTariffPrice() + tariff.getTariff().getPrice() + System.lineSeparator()).getBytes());
            out.write((fields.getTariffDurationInDays() +
                    tariff.getTariff().getDurationInDays() +
                    System.lineSeparator()).getBytes());
            addService(out, tariff, fields);
            if (Objects.nonNull(tariff.getInternet())) {
                out.write((fields.getInternetSpeed() +
                        tariff.getInternet().getSpeed() +
                        System.lineSeparator()).getBytes());
                out.write((fields.getInternetTechnology() +
                        tariff.getInternet().getTechnology() +
                        System.lineSeparator()).getBytes());
            }
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        } catch (IOException | DbException e) {
            e.printStackTrace();
        }
    }

    private void addService(OutputStream out, AnyTariff tariff, TextFields fields) throws IOException {
        if (tariff.getService() instanceof PC) {
            PC pc = (PC) tariff.getService();
            out.write((fields.getPcConnectedPC() + pc.getNumOfConnectedPC() + System.lineSeparator()).getBytes());
        } else if (tariff.getService() instanceof TV) {
            TV tv = (TV) tariff.getService();
            out.write((fields.getTvType() + tv.getType() + System.lineSeparator()).getBytes());
            out.write((fields.getTvNumberOfChannels() + tv.getNumOfChannels() + System.lineSeparator()).getBytes());
        } else {
            Mobile mobile = (Mobile) tariff.getService();
            out.write((fields.getMobileMinutesInside() +
                    mobile.getNumOfMinutesInside() +
                    System.lineSeparator()).getBytes());
            out.write((fields.getMobileMinutesOutside() +
                    mobile.getNumOfMinutesOutside() +
                    System.lineSeparator()).getBytes());
            out.write((fields.getMobileNumberOfMbts() + mobile.getNumOfMbts() + System.lineSeparator()).getBytes());
            out.write((fields.getMobileNumberOfSMS() + mobile.getNumOfSMS() + System.lineSeparator()).getBytes());
        }
    }
}
