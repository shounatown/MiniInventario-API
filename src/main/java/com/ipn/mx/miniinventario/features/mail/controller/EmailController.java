package com.ipn.mx.miniinventario.features.mail.controller;

import com.ipn.mx.miniinventario.features.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/mail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    @ResponseStatus(HttpStatus.OK)
    public void enviarCorreo(@RequestBody Map<String, String> request) {
        String to = request.get("to");
        String asunto = request.get("asunto");
        String texto = request.get("texto");
        
        emailService.enviarCorreo(to, asunto, texto);
    }
}