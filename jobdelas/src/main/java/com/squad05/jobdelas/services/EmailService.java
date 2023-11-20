package com.squad05.jobdelas.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private Configuration freemarkercConfiguration;

    @Value("${spring.mail.username}")
    private String remetente;

    @Autowired
    public EmailService(Configuration freemarkercConfiguration) {
        this.freemarkercConfiguration = freemarkercConfiguration;
    }

    public void enviarEmailHtml(String destinatario, String titulo, Map<String, Object> propriedades) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mineMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mineMessageHelper.setSubject(titulo);
            mineMessageHelper.setFrom(remetente);
            mineMessageHelper.setTo(destinatario);
            mineMessageHelper.setText(getConteudoTemplate(propriedades), true);
            javaMailSender.send(mineMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String getConteudoTemplate(Map<String, Object> model) {
        StringBuffer content = new StringBuffer();

        try {
            content.append(FreeMarkerTemplateUtils
                    .processTemplateIntoString(freemarkercConfiguration.getTemplate("email-cadastro.ftl"), model));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(content);

        return content.toString();
    }

}
