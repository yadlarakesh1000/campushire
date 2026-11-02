package com.campushire.startup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.campushire.repository.JobRepository;
import com.campushire.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Component 
@Order(1)
@RequiredArgsConstructor 
public class StartupSummaryRunner implements ApplicationRunner {
   private  final JobRepository jobRepository;
   private  final StudentRepository studentRepository;


  @Override
  public void run(ApplicationArguments args) throws Exception {
          
         System.out.println(">>> Campushire Ready: "+jobRepository.count() + "jobs" + studentRepository.count() + "students");
         if(args.containsOption("list-jobs")){
          jobRepository.findAll().forEach(job -> System.out.println(">>>  "+job.getTitle() + "@" + job.getCompany()));
         }
  }
  
}
