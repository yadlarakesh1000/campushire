package com.campushire.startup;

import java.time.Clock;
import java.time.Instant;

import org.springframework.stereotype.Component;

import com.campushire.entity.Job;
import com.campushire.repository.JobRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class SeedDataLoader {

    private final JobRepository jobRepository;
    private final Clock clock;

    public SeedDataLoader(JobRepository jobRepository, Clock clock) {
        this.jobRepository = jobRepository;
        this.clock = clock;
    }

    @PostConstruct
    void seed() {
        if (jobRepository.count() > 0) {
            System.out.println(">>> seed skipped, jobs already present");
            return;
        }
        jobRepository.save(new Job(null, "Java Backend Intern", "Zoho", "Chennai", 6.5));
        jobRepository.save(new Job(null, "QA Intern", "Freshworks", "Chennai", 5.0));
        System.out.println(">>> seeded 2 jobs at " + Instant.now(clock));
    }

    @PreDestroy
    void report() {
        System.out.println(">>> shutting down, jobs in DB: " + jobRepository.count());
    }
}
