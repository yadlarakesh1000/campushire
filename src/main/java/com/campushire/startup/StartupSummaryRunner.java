package com.campushire.startup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.campushire.repository.JobRepository;
import com.campushire.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component 
@Order(1)
@Slf4j
@RequiredArgsConstructor 
public class StartupSummaryRunner implements ApplicationRunner {
   private  final JobRepository jobRepository;
   private  final StudentRepository studentRepository;


  @Override
  public void run(ApplicationArguments args) throws Exception {
          
         log.info(">>> Campushire Ready: {} jobs, {} students", jobRepository.count(), studentRepository.count());
         if(args.containsOption("list-jobs")){
          jobRepository.findAll().forEach(job -> log.info(">>> {} @ {}", job.getTitle(), job.getCompany()));
         }
  }
  
}
