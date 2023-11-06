package com.developer.employeemanagementapi.service;
import java.util.List;
import java.util.Optional;

import com.developer.employeemanagementapi.model.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee e);
    void delete(Long id);
    Employee update(Employee e );
}
