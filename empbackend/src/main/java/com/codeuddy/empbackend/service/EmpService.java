package com.codeuddy.empbackend.service;

import com.codeuddy.empbackend.dao.Repo;
import com.codeuddy.empbackend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    Repo repo;

    public List<Employee> getAllEmp() {
        return repo.findAll();
    }

    public Employee getEmpById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Employee saveEmp(Employee user) {
        return repo.save(user);
    }

    public void deleteEmp(int id) {
       repo.deleteById(id);
    }
}
