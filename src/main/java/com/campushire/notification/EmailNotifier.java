package com.campushire.notification;
import org.springframework.stereotype.Service;

import com.campushire.logging.LogMask;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Primary;
@Service
@Slf4j 
@Primary
public class EmailNotifier implements Notifier{

    public void send(String to,String message ){
        log.info("Email sent to {}", LogMask.email(to)); 
    }
}