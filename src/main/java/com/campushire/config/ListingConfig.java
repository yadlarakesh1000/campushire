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
      
      private final double minSalary;
      private final List<String> featuredCompanies;
      private final ZoneId listingZone;
      ListingConfig( @Value("${campushire.min-salary-lpa}") double minSalary,
                     @Value("#{'${campushire.featured-companies}'.split(',')}") List<String> featuredCompanies,
                     @Value("#{clock.zone}") ZoneId listingZone){
             this.minSalary=minSalary;
             this.featuredCompanies=featuredCompanies;
             this.listingZone=listingZone;
      }
}
