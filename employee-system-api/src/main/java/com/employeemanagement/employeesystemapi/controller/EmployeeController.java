package com.employeemanagement.employeesystemapi.controller;

import com.employeemanagement.employeesystemapi.entity.EmployeeEntity;
import com.employeemanagement.employeesystemapi.model.EmployeeModel;
import com.employeemanagement.employeesystemapi.services.EmployeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<EmployeeModel> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employee/{employeeId}")
    public EmployeeModel deleteEmployee(@PathVariable Long employeeId){
        return employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/employee/{employeeId}")
    public EmployeeModel getEmployeeBy( @PathVariable long employeeId){
        return employeeService.getEmployeeById(employeeId);

    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel employee, @PathVariable long employeeId){
        return employeeService.updateEmployee(employee, employeeId);

    }
}
