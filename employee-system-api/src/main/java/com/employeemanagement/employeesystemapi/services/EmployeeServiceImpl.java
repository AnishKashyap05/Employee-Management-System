package com.employeemanagement.employeesystemapi.services;

import com.employeemanagement.employeesystemapi.entity.EmployeeEntity;
import com.employeemanagement.employeesystemapi.model.EmployeeModel;
import com.employeemanagement.employeesystemapi.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public EmployeeModel createEmployee(EmployeeModel employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employees = new ArrayList<>();
        employeeRepository.findAll().forEach( x -> employees.add(EmployeeModel.from(x)));

        return employees;
    }

    @Override
    public EmployeeModel deleteEmployee(long employeeId) {
        EmployeeModel employee = EmployeeModel.from(employeeRepository.findById(employeeId).get());
        employeeRepository.deleteById(employeeId);

        return employee;
    }

    @Override
    public EmployeeModel updateEmployee(EmployeeModel employee, long employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        employeeEntity.emailId = employee.emailId;
        employeeEntity.firstName = employee.firstName;
        employeeEntity.lastName = employee.lastName;

        employeeRepository.save(employeeEntity);
        return employee;

    }

    @Override
    public EmployeeModel getEmployeeById(long employeeId) {

        return EmployeeModel.from(employeeRepository.findById(employeeId).get());
    }

}
