package com.sjprogramming.restapi.repository;

import com.sjprogramming.restapi.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<department, Long> {

}
