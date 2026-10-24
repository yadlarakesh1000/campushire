package com.campushire.demo;

class Student {
    String name;                 // instance — one per object
    static String school = "ABC School";  // static — ONE shared copy

    Student(String name) { this.name = name; }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Asha");
        Student s2 = new Student("Ravi");
        System.out.println(s1.school);   // ABC School
        Student.school = "XYZ School";   // change once...
        System.out.println(s2.school);   // XYZ School — changed for ALL
    }
}