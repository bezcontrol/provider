package ua.kh.baklanov.web.command.tariff;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import ua.kh.baklanov.Route;
import ua.kh.baklanov.exception.DbException;
import ua.kh.baklanov.model.bean.AnyTariff;
import ua.kh.baklanov.model.entity.Mobile;
import ua.kh.baklanov.model.entity.PC;
import ua.kh.baklanov.model.entity.TV;
import ua.kh.baklanov.service.BeanExtractorUtil;
import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.controller.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TariffDownloadPDFCommand implements AbstractCommand, Download {

    private Document document = new Document();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        load(request,response);
        return Route.TARIFFS;
    }

    @Override
    public void load(HttpServletRequest request, HttpServletResponse response) {
        long tariffId = Long.parseLong(request.getParameter(Parameters.TARIFF_ID));
        try {
            AnyTariff tariff = BeanExtractorUtil.extractAnyTariffById(tariffId);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            document.open();
            document.add(new Paragraph(tariff.getTariff().getName()));
            document.add(new Paragraph(String.valueOf(tariff.getTariff().getPrice())));
            document.add(new Paragraph(String.valueOf(tariff.getTariff().getDurationInDays())));
            setServiceParagraphs(tariff);
            document.add(new Paragraph(String.valueOf(tariff.getInternet().getSpeed())));
            document.add(new Paragraph(tariff.getInternet().getTechnology()));
            document.close();
            response.setContentType("application/pdf");
            // the content length
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        } catch (DocumentException | IOException | DbException e) {
            e.printStackTrace();
        }
    }

    private void setServiceParagraphs(AnyTariff tariff) throws DocumentException {
        if(tariff.getService().getClass().isInstance(PC.class)){
            PC pc = (PC) tariff.getService();
            document.add(new Paragraph(String.valueOf(pc.getNumOfConnectedPC())));
        } else if(tariff.getService().getClass().isInstance(TV.class)){
            TV tv = (TV) tariff.getService();
            document.add(new Paragraph(tv.getType()));
            document.add(new Paragraph(String.valueOf(tv.getNumOfChannels())));
        } else {
            Mobile  mobile= (Mobile) tariff.getService();
            document.add(new Paragraph(String.valueOf(mobile.getNumOfMinutesInside())));
            document.add(new Paragraph(String.valueOf(mobile.getNumOfMinutesOutside())));
            document.add(new Paragraph(String.valueOf(mobile.getNumOfMbts())));
            document.add(new Paragraph(String.valueOf(mobile.getNumOfSMS())));
        }
    }
}
