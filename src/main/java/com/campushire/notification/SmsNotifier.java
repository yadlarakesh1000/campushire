package com.campushire.notification;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
@Service
@ConditionalOnProperty(name="campushire.notifier.sms.enabled",havingValue = "true")
public class SmsNotifier implements Notifier{
    
    public void send(String to,String message){
        System.out.println("SMS sent to "+to+" with message "+message);
    }
}