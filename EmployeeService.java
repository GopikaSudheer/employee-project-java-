package com.sjprogramming.restapi.service;

import com.sjprogramming.restapi.employee;
import com.sjprogramming.restapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public employee saveEmployee(employee employee) {
        return employeeRepository.save(employee);
    }

    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
