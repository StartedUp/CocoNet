package com.coconet.mit.appService.service;

import com.coconet.mit.commons.Mail.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.util.Map;

/**
 * Created by ${Prithu} on 19-02-2017.
 */
public class MailService {
    private JavaMailSender mailSender;
    private MailTemplateBuildService mailTemplateBuildService;
    @Autowired
    private Environment environment;
    @Autowired
    public MailService(JavaMailSender mailSender, MailTemplateBuildService mailTemplateBuildService) {
        this.mailSender = mailSender;
        this.mailTemplateBuildService = mailTemplateBuildService;
    }
    public void prepareAndSend(Mailer mailer, Map<String, String> mailTemplateData) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(environment.getRequiredProperty("spring.mail.username"));
            messageHelper.setTo(mailer.getRecipients());
            if (mailer.getBccList()!=null)
                messageHelper.setBcc(mailer.getBccList());
            if (mailer.getCcList()!=null)
                messageHelper.setCc(mailer.getCcList());
            if (mailer.getSubject()!=null)
                messageHelper.setSubject(mailer.getSubject());
            String content = mailTemplateBuildService.build( mailTemplateData);
            messageHelper.setText(content, true);
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    }
}
