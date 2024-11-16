package com.codeuddy.empbackend.dao;

import com.codeuddy.empbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo  extends JpaRepository<Employee,Integer> {
}
