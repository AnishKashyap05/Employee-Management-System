package com.employeemanagement.employeesystemapi.entity;

import com.employeemanagement.employeesystemapi.model.EmployeeModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "firstName")
    public String firstName;
    @Column(name = "lastName")
    public String lastName;

    @Column(name = "emailId")
    public String emailId;

    public EmployeeEntity(int id, String firstName, String lastName, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public EmployeeEntity(){ }
}
