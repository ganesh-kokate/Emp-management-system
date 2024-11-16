package com.codeuddy.empbackend.cotroller;


import com.codeuddy.empbackend.model.Employee;
import com.codeuddy.empbackend.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllers {

    @Autowired
    EmpService empService;

    @CrossOrigin(origins = "*")
    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> showall(){
        List<Employee> emplist=empService.getAllEmp();
        return new ResponseEntity<>(emplist,HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> show(@PathVariable int id){
         Employee emp=empService.getEmpById(id);
        if(emp!=null)
        {
            return new ResponseEntity<>(emp, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/emp")
    public ResponseEntity<Employee> add(@RequestBody Employee emp){
        Employee newemp= empService.saveEmp(emp);
        return new ResponseEntity<>(newemp,HttpStatus.CREATED);
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        try {
            empService.deleteEmp(id);
            return ResponseEntity.noContent().build(); // Return 204 No Content on success
        } catch (Exception e) {
            // Log the exception for debugging

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return 500 on error
        }
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping("/emp/{id}")
    public Employee update(@PathVariable int id,@RequestBody Employee emp){
        Employee existingEmp = empService.getEmpById(id);
        if (existingEmp != null) {
            if(emp.getFirstName()!=null)
            {
                existingEmp.setFirstName(emp.getFirstName());
            }

            if(emp.getLastName()!=null)
            {
                existingEmp.setLastName(emp.getLastName());
            }

            if(emp.getMailId()!=null)
            {
                existingEmp.setMailId(emp.getMailId());
            }
            return empService.saveEmp(existingEmp);
        }
        return empService.saveEmp(existingEmp);
    }

}
