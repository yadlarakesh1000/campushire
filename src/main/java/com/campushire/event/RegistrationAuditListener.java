package com.campushire.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Component 
public class RegistrationAuditListener {
  
  @EventListener @Order(1)
  public void audit(StudentRegisteredEvent e){
     log.info("Audit: student registered id={}", e.studentId());
  }
}
