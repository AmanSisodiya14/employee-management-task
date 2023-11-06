package com.developer.employeemanagementapi.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Department {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long departmentId;

    private String departmentName;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    
    @Temporal(TemporalType.TIMESTAMP)
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

    public Department() {
    }

    public Long getId() {
        return this.departmentId;
    }

    public void setId(Long id) {
        this.departmentId = id;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
            " id='" + getId() + "'" +
            ", departmentName='" + getDepartmentName() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", updateAt='" + getUpdateAt() + "'" +
            "}";
    }


}
