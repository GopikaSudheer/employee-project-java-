package com.sjprogramming.restapi.service;

import com.sjprogramming.restapi.department;
import com.sjprogramming.restapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public department saveDepartment(department department) {
        return departmentRepository.save(department);
    }

    public List<department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
