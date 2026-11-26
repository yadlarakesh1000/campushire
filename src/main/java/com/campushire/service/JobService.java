package com.campushire.service;

import com.campushire.config.CampusHireProperties;
import com.campushire.entity.Job;
import com.campushire.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final CampusHireProperties properties;
    private final JobRepository jobRepository;
    
    public JobService(JobRepository jobRepository,CampusHireProperties properties) {
        this.jobRepository = jobRepository;
        this.properties=properties;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job job) {
        if(!jobRepository.existsById(id)){
            return null;
        }
        job.setId(id);
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
    public List<Job> getFeaturedJobs(){
         return getAllJobs().stream().filter(job -> properties.featuredCompanies().contains(job.getCompany())).filter(job -> job.getSalaryLpa() >= properties.minSalaryLpa()).toList();

    }
    public Job updateSalary(Long id,double salaryLpa){
        Job job = jobRepository.findById(id).orElse(null);
        if(job==null) return null;
        
        job.setSalaryLpa(salaryLpa);
        Job saved = jobRepository.save(job);
        
     return saved;
    }
    public List<Job> searchJobs(String location,double minSalary){
          return getAllJobs().stream().filter(job->location==null || location.equalsIgnoreCase(job.getLocation())).
          filter(job->job.getSalaryLpa()>=minSalary).toList();
    }
}
