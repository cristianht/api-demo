package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apidemo/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getStudents() {
        return "Esta es la lista de estudiantes";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public String getStudent(Long id) {
        return "Este es el estudiante con id " + id;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {
        this.studentService.addStudent(student);
        return "Estudiante añadido con id " + student.getId() + "";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public String updateStudent(Long id) {
        return "Estudiante con id " + id + " actualizado";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(Long id) {
        return "Estudiante con id " + id + " eliminado";
    }

}
