package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/apidemo/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    //@RequestMapping(value = "/students", method = RequestMethod.GET)
    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        List<StudentDTO> students = this.studentService.getStudents();
        return ResponseEntity.ok(students);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentDTO> getStudent(@NotNull @PathVariable("id") Long id) {
        StudentDTO studentDTO = this.studentService.getStudent(id);
        return ResponseEntity.ok(studentDTO);
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Long idEntity = this.studentService.addStudent(studentDTO);
        return ResponseEntity.created(URI.create("/students/" + idEntity))
                .body(studentDTO);
        //return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public String updateStudent(Long id) {
        return "Estudiante con id " + id + " actualizado";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@NotNull @PathVariable("id") Long id) {
        this.studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
