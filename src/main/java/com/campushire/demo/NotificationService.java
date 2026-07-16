package com.campushire.demo;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
  public NotificationService(){
     System.out.println(">>> NotificationService created by the container");
  }
    public void notifyStudent(String studentName, String message) {
        System.out.println("Notify " + studentName + ": " + message);
    }
  
}
