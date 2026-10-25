package com.campushire.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component 
public class RegistrationAuditListener {
  
  @EventListener @Order(1)
  public void audit(StudentRegisteredEvent e){
      System.out.println(">>> Audit: student registered id="+e.studentId());
  }
}
