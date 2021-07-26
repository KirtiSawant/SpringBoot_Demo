package com.curddemo.demo.dao;

import com.curddemo.demo.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    List<Student> findAll();
   /* @Query("select * from stud s where s.firstName=:firstName & s.lastName=:lastName")
    List<Student>findByfirstNameAndlastName(String firstName,String lastName);

    List<Student> findBylastName(String lastName);

    List<Student> findByfirstNameAndlastName(String firstName);*/
}
