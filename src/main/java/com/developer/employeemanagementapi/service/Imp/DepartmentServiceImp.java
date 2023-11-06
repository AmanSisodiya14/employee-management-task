package com.developer.employeemanagementapi.service.Imp;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.employeemanagementapi.model.Department;
import com.developer.employeemanagementapi.repository.DepartmentRepo;
import com.developer.employeemanagementapi.service.DepartmentService;

@Service
public class DepartmentServiceImp implements DepartmentService{
    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public List<Department> findAll() {
        return this.departmentRepo.findAll();
    }

    @Override
    public Optional<Department> findById(Long id) {
        return this.departmentRepo.findById(id);
    }

    @Override
    public Department save(Department d) {
      return this.departmentRepo.save(d);
    }

    @Override
    public void delete(Long id) {
     this.departmentRepo.deleteById(id);
    }
    
}
