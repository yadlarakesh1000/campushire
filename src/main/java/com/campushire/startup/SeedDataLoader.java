package com.campushire.startup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.campushire.entity.Job;
import com.campushire.repository.JobRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
public class SeedDataLoader {

    private final JobRepository jobRepository;
    private final Clock clock;
    private final Resource jobFiles;

    public SeedDataLoader(JobRepository jobRepository, Clock clock,@Value("${campushire.seed.jobs-file}")Resource jobFiles) {
        this.jobRepository = jobRepository;
        this.clock = clock;
        this.jobFiles=jobFiles;
    }

    @PostConstruct
    void seed() {
        if (jobRepository.count() > 0) {
            System.out.println(">>> seed skipped, jobs already present");
            return;
        }
        if(!jobFiles.exists()){
            throw new IllegalStateException("seed file not found"+jobFiles.getDescription());
        }
        int saved =0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(jobFiles.getInputStream(), StandardCharsets.UTF_8))){
              reader.readLine();
              String line;
              while ((line=reader.readLine())!=null) {
                       if(line.isBlank()) continue;
                    String[] c = line.split(",");
                    jobRepository.save(new Job(null,c[0].trim(),c[1].trim(),c[2].trim(),Double.parseDouble((c[3].trim()))));
                    saved++;
              }
            }
              catch(IOException e){
                 throw new UncheckedIOException("could not read"+jobFiles.getDescription(),e);
              }
                System.out.println(">>> seeded "+saved+ "jobs from"+jobFiles.getDescription()+"at"+Instant.now(clock));
        }
    
    

    @PreDestroy
    void report() {
        System.out.println(">>> shutting down, jobs in DB: " + jobRepository.count());
    }
}
