package com.coconet.mit.commons.Mail;

/**
 * Created by ${Prithu} on 19-02-2017.
 */
public class Mailer {
    private String subject;
    private String[] recipients;
    private String[] bccList;
    private String[] ccList;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public void setRecipients(String[] recipients) {
        this.recipients = recipients;
    }

    public String[] getBccList() {
        return bccList;
    }

    public void setBccList(String[] bccList) {
        this.bccList = bccList;
    }

    public String[] getCcList() {
        return ccList;
    }

    public void setCcList(String[] ccList) {
        this.ccList = ccList;
    }
}
