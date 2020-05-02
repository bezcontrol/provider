package ua.kh.baklanov.web.command.tariff;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class TariffDownloadPDFCommand implements AbstractCommand, Download {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        load(request,response);
        return Route.TARIFFS;
    }

    @Override
    public void load(HttpServletRequest request, HttpServletResponse response) {
        Document document = new Document();
        TextFields fields = (TextFields) request.getServletContext().getAttribute("textFields");
        long tariffId = Long.parseLong(request.getParameter(Parameters.TARIFF_ID));
        try {
            AnyTariff tariff = BeanExtractorUtil.extractAnyTariffById(tariffId);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            document.open();
            document.add(new Paragraph(fields.getTariffName()+tariff.getTariff().getName()));
            document.add(new Paragraph(fields.getTariffPrice()+tariff.getTariff().getPrice()));
            document.add(new Paragraph(fields.getTariffDurationInDays()+tariff.getTariff().getDurationInDays()));
            setServiceParagraphs(document,tariff, fields);
            if(Objects.nonNull(tariff.getInternet())){
                document.add(new Paragraph(fields.getInternetSpeed()+tariff.getInternet().getSpeed()));
                document.add(new Paragraph(fields.getInternetTechnology()+tariff.getInternet().getTechnology()));
            }
            document.close();
            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                    "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
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

    private void setServiceParagraphs(Document document,AnyTariff tariff, TextFields fields) throws DocumentException {
        if(tariff.getService() instanceof  PC){
            PC pc = (PC) tariff.getService();
            document.add(new Paragraph(fields.getPcConnectedPC()+pc.getNumOfConnectedPC()));
        } else if(tariff.getService() instanceof  TV){
            TV tv = (TV) tariff.getService();
            document.add(new Paragraph(fields.getTvType()+tv.getType()));
            document.add(new Paragraph(fields.getTvNumberOfChannels()+tv.getNumOfChannels()));
        } else {
            Mobile  mobile= (Mobile) tariff.getService();
            document.add(new Paragraph(fields.getMobileMinutesInside()+mobile.getNumOfMinutesInside()));
            document.add(new Paragraph(fields.getMobileMinutesOutside()+mobile.getNumOfMinutesOutside()));
            document.add(new Paragraph(fields.getMobileNumberOfMbts()+mobile.getNumOfMbts()));
            document.add(new Paragraph(fields.getMobileNumberOfSMS()+mobile.getNumOfSMS()));
        }
    }
}
