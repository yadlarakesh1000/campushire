package com.campushire.service;

import com.campushire.config.ListingConfig;
import com.campushire.entity.Job;
import com.campushire.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private  final ListingConfig listingConfig;
    public JobService(JobRepository jobRepository,ListingConfig listingConfig) {
        this.jobRepository = jobRepository;
        this.listingConfig=listingConfig;
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
        job.setId(id);
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
    public List<Job> getFeaturedJobs(){
         return getAllJobs().stream().filter(job -> listingConfig.getFeaturedCompanies().contains(job.getCompany())).filter(job -> job.getSalaryLpa() >= listingConfig.getMinSalary()).toList();

    }
}
