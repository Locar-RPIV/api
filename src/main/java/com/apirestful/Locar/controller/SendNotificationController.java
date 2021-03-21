package com.apirestful.Locar.controller;

import com.apirestful.Locar.Services.SendEmailService;
import com.apirestful.Locar.model.Notification;
import com.apirestful.Locar.model.NotificationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class SendNotificationController {
    @Autowired
    SendEmailService sendEmailService;

    @PostMapping(value="/notification")
    public NotificationResponse sendNotification(@RequestBody Notification notification) {
        System.out.println(notification.toString());
        try {
            sendEmailService.sendSimpleMessage(
                notification.getEmailToSend(), 
                "Ótimas notícias para você", 
                "Olá "+notification.getPartnerName()+", gostariamos de informar que seu veículo " +
                notification.getVehicleModel() +" ("+notification.getVehiclePlate()+") foi reservado."+
                "Pedimos para que você leve o veículo até a seguinte filial: "+notification.getBranch()+".");
                return new NotificationResponse("Notificação enviada com sucesso!");
        } catch (Exception e) {
            System.out.println(e);
            return new NotificationResponse("Houve um erro ao enviar a notificação!");
        }
    }
}
