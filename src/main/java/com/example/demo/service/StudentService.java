package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    public Student getStudent(Long id);

    public List<Student> getStudents();

    public Student addStudent(Student student);

}
