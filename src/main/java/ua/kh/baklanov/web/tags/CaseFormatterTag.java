package ua.kh.baklanov.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import java.io.IOException;


public class CaseFormatterTag extends BodyTagSupport {
    private String mCase;

    public void setCase(String pCase) {
        mCase = pCase;
    }


    public int doAfterBody() throws JspException {
        try {
            BodyContent bc = getBodyContent();
            String body = bc.getString();
            JspWriter out = bc.getEnclosingWriter();
            if (body != null) {
                if ("upper".equalsIgnoreCase(mCase)) {
                    out.print(body.toUpperCase());
                } else {
                    out.print(body.toLowerCase());
                }
            }
        } catch (IOException ioe) {
            throw new JspException("Error: " + ioe.getMessage());
        }
        return SKIP_BODY;
    }
}
