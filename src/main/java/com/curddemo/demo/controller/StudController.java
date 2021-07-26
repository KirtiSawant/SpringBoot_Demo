package com.curddemo.demo.controller;

import com.curddemo.demo.dao.StudentRepository;
import com.curddemo.demo.exception.ResourceNotFoundException;
import com.curddemo.demo.model.Student;
import com.curddemo.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudController {

    @Autowired
    StudentService studentService;
    //StudentRepository studentRepository;

    @GetMapping("student")
    public List<Student> getAllStudent() {
        return this.studentService.getAllStudent();
    }

    @GetMapping("student/{id}")
    public Student getStudentById(@RequestBody Student student, @PathVariable("id") int id) {
        return this.studentService.getStudentById(id);
    }

    @PostMapping("students")
    public Student createStudent(@RequestBody Student student){
        return this.studentService.createStudent(student);
    }

    @PutMapping("student/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int id){
        return this.studentService.updateStudent(student,id);
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id){
        return this.studentService.deleteStudent(id);
    }

}


