package com.example.demo.service.impl;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.exceptions.BussinessException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;


    @Override
    public StudentDTO getStudent(Long id) {
        Optional<Student> student = this.repository.findById(id);
        if (student.isPresent()) {
            return student.get().toDTO();
        } else {
            throw new BussinessException("Student not found");
        }
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students = this.repository.findAll();
        return students.stream().map(Student::toDTO).collect(Collectors.toList());
    }

    @Override
    public Long addStudent(StudentDTO studentDTO) {
        if (repository.existsByEmail(studentDTO.getEmail())) {
            throw new BussinessException("Email already exists");
        } else {
            Student student = studentDTO.toEntity();
            student = this.repository.save(student);
            return student.getId();
        }
    }

    @Override
    public void deleteStudent(Long id) {
        this.repository.deleteById(id);
    }

}
