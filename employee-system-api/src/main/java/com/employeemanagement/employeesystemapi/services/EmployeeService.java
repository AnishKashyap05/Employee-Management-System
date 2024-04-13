package com.employeemanagement.employeesystemapi.services;

import com.employeemanagement.employeesystemapi.entity.EmployeeEntity;
import com.employeemanagement.employeesystemapi.model.EmployeeModel;

import java.util.List;

public interface EmployeeService{

    EmployeeModel createEmployee(EmployeeModel employee);

    List<EmployeeModel> getAllEmployees();

    EmployeeModel deleteEmployee(long employeeId);

    EmployeeModel updateEmployee(EmployeeModel employee, long employeeId);

    EmployeeModel getEmployeeById(long employeeId);
}
