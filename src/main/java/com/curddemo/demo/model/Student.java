package com.curddemo.demo.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;

@Data
@Table("Stud")
public class Student {
    @Id
    private int id;

    @Column("first_name")
    @NotBlank(message = "Please provide first Name")
    private String firstName;

    @NotBlank(message = "Please provide last Name")
    @Column("last_name")
    private String lastName;

    @Column("email")
    private String email;

    @Column("dob")
    private String dob;

    public Student(int id, String firstName, String lastName, String email, String dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }

}