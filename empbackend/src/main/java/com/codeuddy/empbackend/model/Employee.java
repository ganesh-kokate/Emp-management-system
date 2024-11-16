package com.codeuddy.empbackend.model;


import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "First_Name")
    String firstName;

    @Column(name = "Last_Name")
    String lastName;

    @Column(name = "Mail_Id")
    String mailId;


}
