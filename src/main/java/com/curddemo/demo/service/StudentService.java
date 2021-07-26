package com.curddemo.demo.service;

import com.curddemo.demo.dao.StudentRepository;
import com.curddemo.demo.exception.ResourceNotFoundException;
import com.curddemo.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

 /*   public List<Student> getAllStudent(String firstName, String lastName) {
         List<Student> students = new ArrayList<Student>();

        if (firstName != null) {
            if (lastName != null) {
                return studentRepository.findByfirstNameAndlastName(firstName,lastName);
            } else {
                return studentRepository.findBylastName(lastName);
            }

        }
        return students;
    }*/

    public Student getStudentById(int id) {
         return studentRepository.findById(id).get();

    }

    public List<Student> getStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student updateStudent(int id, Student student) {
        Student stud = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        stud.setFirstName(student.getFirstName());
        stud.setLastName(student.getLastName());
        stud.setEmail(student.getEmail());
        stud.setDob(student.getDob());
         return stud;
    }

    public  void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
}
