package com.developer.employeemanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.employeemanagementapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
