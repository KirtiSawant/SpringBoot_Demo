package com.curddemo.demo.service;

import com.curddemo.demo.dao.StudentRepository;
import com.curddemo.demo.exception.ResourceNotFoundException;
import com.curddemo.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found id:" + id));
    }
    public List<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student updateStudent(Student student,int id) {
        Student stud= studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found id:" + id));
        stud.setFirstName(student.getFirstName());
        stud.setLastName(student.getLastName());
        stud.setEmail(student.getEmail());
        stud.setDob(student.getDob());
        return this.studentRepository.save(stud);
    }
    public ResponseEntity<Student> deleteStudent(int id) {
        Student students=studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student not found id:"+id));
        this.studentRepository.delete(students);
        return ResponseEntity.ok().build();
    }
}
