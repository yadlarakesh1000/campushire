package com.campushire.controller;

import com.campushire.dto.SalaryUpdateRequest;
import com.campushire.entity.Job;
import com.campushire.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
   
    @GetMapping("/featured")
    public List<Job> getFeaturedJobs() {
         return  jobService.getFeaturedJobs();
    }
    @GetMapping
    public List<Job> getJobs(@RequestParam(required=false)String location,
                            @RequestParam (defaultValue = "0")double minSalary){
                                return jobService.searchJobs(location, minSalary);
                            }
    
    
   @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job saved = jobService.createJob(job);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
        Job updated = jobService.updateJob(id, job);
        if(updated==null){
          return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/salary")
     public ResponseEntity<Job> updateSalary(@PathVariable Long id,@RequestBody SalaryUpdateRequest request ){
      Job response = jobService.updateSalary(id, request.salaryLpa());
      if(response==null){
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(response);
     }
   
    
}
