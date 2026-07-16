package com.campushire.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocDemo {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext("com.campushire.demo")) { // ④
            System.out.println("Beans managed: " + context.getBeanDefinitionCount());

            ApplicationService s1 = context.getBean(ApplicationService.class); // ⑤
            ApplicationService s2 = context.getBean(ApplicationService.class);
            System.out.println("Same instance? " + (s1 == s2)); // ⑥ true — singleton

            s1.applyToJob("Rakesh", "Java Backend Intern @ Zoho");
        } // ⑦
    }
}
