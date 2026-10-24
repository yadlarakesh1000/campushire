package com.campushire.config;

import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component 
@Getter 
@Setter 
public class ListingConfig {
       @Value("${campuseire.min-salary-lpa}")
      private  double minSalary;
       @Value ("#{'${campushire.featured-companies}'.split(',')}")
      private List<String> featuredCompanies;
       @Value("#{clock.zone}")
      private ZoneId listingZone;
}
