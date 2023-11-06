package com.developer.employeemanagementapi.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empid;

    private String firstName;

    private  String lastName;
    private  String email;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "departmentId")
    private Department department;

    private Date createAt;
    private Date updateAt;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
        this.updateAt = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        this.updateAt = new Date();
    }

    public Employee() {
    }

    public Long getEmpId() {
        return this.empid;
    }

    public void setEmpId(Long id) {
        this.empid = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
   

    @Override
    public String toString() {
        return "{" +
            " id='" + getEmpId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", department='" + getDepartment() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", updateAt='" + getUpdateAt() + "'" +
            "}";
    }

}
