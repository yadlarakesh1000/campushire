package com.campushire.notification;
import org.springframework.stereotype.Service;
@Service
public class SmsNotifier implements Notifier{
    
    public void send(String to,String message){
        System.out.println("SMS sent to "+to+" with message "+message);
    }
}