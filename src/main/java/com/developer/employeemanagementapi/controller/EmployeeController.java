package com.developer.employeemanagementapi.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.employeemanagementapi.model.Employee;
import com.developer.employeemanagementapi.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>>  findAll(){
        List<Employee> emp = this.employeeService.findAll();

        if(emp.size()<0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(emp);
    }

    @PostMapping("/save")
 public ResponseEntity<Employee> save(@RequestBody Employee e){
        Employee emp = null;
        


        try{
        System.out.println(e);
            emp = this.employeeService.save(e);
            System.out.println(emp);
            return ResponseEntity.status(HttpStatus.CREATED).build();


        }catch(Exception exp) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmp(@PathVariable("id") Long id){
        

            Optional<Employee> e = this.employeeService.findById(id);
            if(e.isPresent())
                return ResponseEntity.status(HttpStatus.CREATED).body(e);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee emp,@PathVariable("id") Long id){
         Optional<Employee> e = this.employeeService.findById(id);
            if(e.isPresent()){
                emp.setCreateAt(e.get().getCreateAt());
                emp.setEmpId(id);
                Employee e1 = this.employeeService.save(emp);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(e1);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }   
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEMployee(@PathVariable("id") Long id){
        Optional<Employee> e = this.employeeService.findById(id);
            if(e.isPresent()){
              try{
                this.employeeService.delete(id);
                return ResponseEntity.ok().build();
              }catch(Exception exception){
                
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
              }
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            
    }
}