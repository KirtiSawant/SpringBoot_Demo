package com.curddemo.demo.controller;

import com.curddemo.demo.model.Student;
import com.curddemo.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudController {

    @Autowired
    private StudentService studentService;
     @PostMapping("students")
      public ResponseEntity<String> saveStudent(@RequestBody @Valid Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok("User data is valid");
    }
       @GetMapping("student")
        public List<Student> getStudent(){
            return studentService.getStudent();
     }
   /*   @GetMapping("/student/name")
       public Student getAllStudent(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName) {
          {
              return (Student) studentService.getAllStudent(firstName,lastName);
          }
      }*/
        @GetMapping("/student/{id}")
        public Student getStudentById(@PathVariable("id") int id) {
            return studentService.getStudentById(id);
    }

         @PutMapping("/students/{id}")
          public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
          Student student1 = studentService.updateStudent(id, student);
          return new ResponseEntity<>(student1, HttpStatus.OK);
    }
    @DeleteMapping("/student/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }
      }