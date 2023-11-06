package com.developer.employeemanagementapi.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.employeemanagementapi.model.Employee;
import com.developer.employeemanagementapi.repository.EmployeeRepository;
import com.developer.employeemanagementapi.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
      return this.employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee e) {
        return this.employeeRepository.save(e);
    }

    @Override
    public void delete(Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Employee update(Employee e) {
      return this.employeeRepository.save(e);
    }
    
}
