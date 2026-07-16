package com.campushire.notification;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
@Service
@Primary
public class EmailNotifier implements Notifier{

    public void send(String to,String message ){
        System.out.println("Email sent to "+to+" with message "+message);
    }
}