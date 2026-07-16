package com.campushire.demo;

import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

 private final NotificationService notificationService;
 public ApplicationService(NotificationService notificationService){
  this.notificationService= notificationService;
 }
  public void applyToJob(String studentName, String jobTitle) {
        // (persistence comes in Part E — for now just the interaction)
        notificationService.notifyStudent(studentName, "Applied to " + jobTitle);
    }

}
