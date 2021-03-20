package com.apirestful.Locar.Services;

/**
 * Created by Olga on 8/22/2016.
 */
public interface EmailService {
    void sendSimpleMessage(String to, String subject,String text);
}