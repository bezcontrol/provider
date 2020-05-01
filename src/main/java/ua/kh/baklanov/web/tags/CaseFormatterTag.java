package ua.kh.baklanov.web.tags;

import org.apache.log4j.Logger;
import ua.kh.baklanov.exception.Messages;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.Locale;


public class CaseFormatterTag extends BodyTagSupport {
    private static final Logger LOG = Logger.getLogger(CaseFormatterTag.class);
    private String mCase;

    public CaseFormatterTag(){ }

    public void setCase(String pCase) {
        mCase = pCase;
    }

    @Override
    public int doAfterBody() throws JspException {
        try {
            BodyContent bc = getBodyContent();
            String body = bc.getString();
            JspWriter out = bc.getEnclosingWriter();
            if (body != null) {
                if ("upper".equalsIgnoreCase(mCase)) {
                    out.print(body.toUpperCase(Locale.getDefault()));
                } else {
                    out.print(body.toLowerCase(Locale.getDefault()));
                }
            }
        } catch (IOException ioe) {
            LOG.error(Messages.ERROR_CASE_FORMATTER_TAG, ioe);
            throw new JspException(Messages.ERROR_CASE_FORMATTER_TAG + ioe.getMessage());
        }
        return SKIP_BODY;
    }
}
