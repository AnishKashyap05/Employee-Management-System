package com.employeemanagement.employeesystemapi.service;

import com.employeemanagement.employeesystemapi.entity.EmployeeEntity;
import com.employeemanagement.employeesystemapi.model.EmployeeModel;
import com.employeemanagement.employeesystemapi.repository.EmployeeRepository;
import com.employeemanagement.employeesystemapi.services.EmployeeService;
import com.employeemanagement.employeesystemapi.services.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    void itShouldGetAllEmployees() {
        List<EmployeeModel> expectedEmployeeModels = List.of(
                new EmployeeModel(1,"Anish","M N","mnanish55@gmail.com"),
                new EmployeeModel(2,"Suresh","M N","mnanish55@gmail.com")
        );

        List<EmployeeEntity> employeeEntities = List.of(
                new EmployeeEntity(1,"Anish","M N","mnanish55@gmail.com"),
                new EmployeeEntity(2,"Suresh","M N","mnanish55@gmail.com")
        );

        when(employeeRepository.findAll()).thenReturn(employeeEntities);

        List<EmployeeModel> response = employeeService.getAllEmployees();

        assertEquals(expectedEmployeeModels, response);

    }

    @Test
    void itShouldGetEmployeeWithSpecificId() {
        long testEmployeeId = 1;
        EmployeeModel expectedEmployee =
                new EmployeeModel(1,"Anish","M N","mnanish55@gmail.com");
        EmployeeEntity employeeEntity =
                new EmployeeEntity(1,"Anish","M N","mnanish55@gmail.com");

        when(employeeRepository.findById(testEmployeeId)).thenReturn(Optional.of(employeeEntity));

        EmployeeModel response = employeeService.getEmployeeById(testEmployeeId);

        assertEquals(expectedEmployee, response);
    }

    @Test
    void itShouldDeleteAnEmployeeWithGivenId() {
        long testEmployeeId = 1;
        EmployeeModel expectedEmployee =
                new EmployeeModel(1,"Anish","M N","mnanish55@gmail.com");
        EmployeeEntity employeeEntity =
                new EmployeeEntity(1,"Anish","M N","mnanish55@gmail.com");

        when(employeeRepository.findById(testEmployeeId)).thenReturn(Optional.of(employeeEntity));

        EmployeeModel response = employeeService.deleteEmployee(testEmployeeId);

        assertEquals(expectedEmployee, response);
    }

}
