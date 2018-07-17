package com.coconet.mit.appService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

/**
 * Created by ${Prithu} on 18-02-2017.
 */

public class MailTemplateBuildService {
    private TemplateEngine templateEngine;

    @Autowired
    public MailTemplateBuildService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(Map<String, String> mailTemplateData) {
        Context context = new Context();
        for(Map.Entry<String, String> entry : mailTemplateData.entrySet()) {
            String templateVariableName = entry.getKey();
            String templateVariableValue = entry.getValue();
            context.setVariable(templateVariableName, templateVariableValue);
        }
        return templateEngine.process(mailTemplateData.get("templateName"), context);
    }
}
