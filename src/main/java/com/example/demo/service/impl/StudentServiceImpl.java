package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;


    @Override
    public Student getStudent(Long id) {
        return null;
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        return this.repository.save(student);
    }

}
