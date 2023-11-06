package com.developer.employeemanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developer.employeemanagementapi.model.Department;



@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long>{
    
}
