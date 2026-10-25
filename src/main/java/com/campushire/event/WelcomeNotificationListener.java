package com.campushire.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.campushire.notification.Notifier;

import lombok.RequiredArgsConstructor;

@Component 
@RequiredArgsConstructor 
public class WelcomeNotificationListener {
        private final Notifier notifier;

        @EventListener @Order(1)
        public void onStudentRegistered(StudentRegisteredEvent e){
           
            
        notifier.send(e.email(), "welcome to campushire");
            
        }
}
