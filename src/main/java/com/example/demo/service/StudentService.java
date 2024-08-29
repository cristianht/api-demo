package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    public StudentDTO getStudent(Long id);

    public List<StudentDTO> getStudents();

    public Long addStudent(StudentDTO student);

    public void deleteStudent(Long id);

}
