package com.ipn.mx.miniinventario.features.mail.service.impl;

import com.ipn.mx.miniinventario.features.mail.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImpls implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("classpath:static/img/escom.jpg")
    private Resource resorceFile;
    @Override
    public void enviarCorreo(String to, String asunto, String texto) {
        MimeMessage mensaje = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try{
            helper = new MimeMessageHelper(mensaje, true, "UTF-8");
            helper.addAttachment("archivo", new File(resorceFile.getFile().toURI()));

            helper.setFrom("noreply@gmail.com", "Envio de correos via Spring");
            helper.setSubject(asunto);
            helper.setText(texto, true);
            helper.setTo(to);
            helper.setCc("jonathanrojasiv@gmail.com");
            helper.setBcc("rojasromero.escom@gmail.com");
            mailSender.send(mensaje);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
