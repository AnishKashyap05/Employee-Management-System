package com.employeemanagement.employeesystemapi.model;


import com.employeemanagement.employeesystemapi.entity.EmployeeEntity;
import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class EmployeeModel {
    @Nullable
    public long id;
    public String firstName;
    public String lastName;
    public String emailId;

    public EmployeeModel(long id, String firstName, String lastName, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public static EmployeeModel from(EmployeeEntity employeeEntity){
        return new EmployeeModel(
                employeeEntity.id,
                employeeEntity.firstName,
                employeeEntity.lastName,
                employeeEntity.emailId
        );
    }
}
