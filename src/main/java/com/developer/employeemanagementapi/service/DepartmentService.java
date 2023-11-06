package com.developer.employeemanagementapi.service;

import java.util.List;
import java.util.Optional;

import com.developer.employeemanagementapi.model.Department;

public interface DepartmentService {
    List<Department> findAll();
    Optional<Department> findById(Long id);
    Department save(Department d);
    void delete(Long id);
}
