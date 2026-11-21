package com.campushire.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.core.io.Resource;
import org.springframework.util.unit.DataSize;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@ConfigurationProperties (prefix = "campushire")
@Validated 
public record CampusHireProperties (
      @NotNull @PositiveOrZero  Double minSalaryLpa,
      @NotEmpty List<String> featuredCompanies,
      @NotBlank  String currency,
      @Valid @NotNull Seed seed){

        public record Seed(
                @NotNull Resource jobsFile,
                @DefaultValue ("1MB") DataSize maxFilSize)   {

                }             
        
      }



