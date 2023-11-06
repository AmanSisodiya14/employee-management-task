package com.developer.employeemanagementapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.developer.employeemanagementapi.model.Department;

import com.developer.employeemanagementapi.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Department>> findAll(){
        List<Department> d = this.departmentService.findAll();

        if(d.size()<0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(d);
    }
    @PostMapping("/save")
    public ResponseEntity<Department> save(@RequestBody Department d){
        
        System.out.println(d);
        try{
            
            Department deprt=this.departmentService.save(d);
            return ResponseEntity.status(HttpStatus.CREATED).body(deprt);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Department> update(@RequestBody Department d,@PathVariable("id") Long id){
        Optional<Department> deprt = this.departmentService.findById(id);
        
        System.out.println("Update"+d);
        if(deprt.isPresent()){
            d.setId(id);
            d.setCreateAt(deprt.get().getCreateAt());
            this.departmentService.save(d);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(d);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Long id){
        Optional<Department> e = this.departmentService.findById(id);
            if(e.isPresent()){
              try{
                this.departmentService.delete(id);
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
