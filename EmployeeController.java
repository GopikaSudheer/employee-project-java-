package com.sjprogramming.restapi.controller;

import com.sjprogramming.restapi.department;
import com.sjprogramming.restapi.employee;
import com.sjprogramming.restapi.department;
import com.sjprogramming.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<employee> createEmployee(@RequestBody employee employee) {
        employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<employee>> getAllEmployees() {
        List<employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable Long id) {
        employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable Long id, @RequestBody employee employeeDetails) {
        employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        employee.setName(employeeDetails.getName());
        employee.setDateOfBirth(employeeDetails.getDateOfBirth());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setAddress(employeeDetails.getAddress());
        employee.setRole(employeeDetails.getRole());
        employee.setJoiningDate(employeeDetails.getJoiningDate());
        employee.setYearlyBonusPercentage(employeeDetails.getYearlyBonusPercentage());
        employee.setReportingManager(employeeDetails.getReportingManager());

        employee updatedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);

    }

    @PutMapping("/{id}/department")
    public ResponseEntity<employee> updateEmployeeDepartment(@PathVariabl long id,
            @RequestBody department newDepartment) {
        employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        employee.setDepartment(newDepartment);

        employee updatedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
