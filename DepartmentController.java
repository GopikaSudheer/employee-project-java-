package com.sjprogramming.restapi.controller;

import com.sjprogramming.restapi.department;
import com.sjprogramming.restapi.employee;
import com.sjprogramming.restapi.service.DepartmentService;
import com.sjprogramming.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired

    @PostMapping
    public ResponseEntity<department> createDepartment(@RequestBody department department) {
        department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    @GetMapping
    public ResponseEntity<List<department>> getAllDepartments() {
        List<department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<department> getDepartmentById(@PathVariable Long id) {
        department department = departmentService.getDepartmentById(id);
        if (department == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<department> updateDepartment(@PathVariable Long id,
            @RequestBody department departmentDetails) {
        department department = departmentService.getDepartmentById(id);
        if (department == null) {
            return ResponseEntity.notFound().build();
        }

        department.setName(departmentDetails.getName());

        department updatedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        department department = departmentService.getDepartmentById(id);
        if (department == null) {
            return ResponseEntity.notFound().build();
        }

        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/department")
    public ResponseEntity<employee> updateEmployeeDepartment(@PathVariable Long id,
            @RequestBody String newDepartment) {
        employee employee = EmployeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        employee.setDepartment(newDepartment);

        employee updatedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
