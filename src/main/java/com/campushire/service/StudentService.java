package com.campushire.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.campushire.notification.Notifier;

import com.campushire.entity.Student;
import com.campushire.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final Notifier notifier;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        Student saved = studentRepository.save(student);
        notifier.send(saved.getEmail(),"welcome to campushire");
        return saved;
        //notifier.send(student.getEmail(),"welcome to campushire");
        //return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
