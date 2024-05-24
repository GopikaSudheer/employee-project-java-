package com.sjprogramming.restapi;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class employee {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private Date dob;
    @Column
    private int salary;
    @Column
    private String department;
    @Column
    private String address;
    @Column
    private String role;
    @Column
    private Date jod;
    @Column
    private int ybp;
    @Column
    private String rm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dob;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dob = dateOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getJoiningDate() {
        return jod;
    }

    public void setJoiningDate(Date joiningDate) {
        this.jod = joiningDate;
    }

    public int getYearlyBonusPercentage() {
        return ybp;
    }

    public void setYearlyBonusPercentage(int yearlyBonusPercentage) {
        this.ybp = yearlyBonusPercentage;
    }

    public String getReportingManager() {
        return rm;
    }

    public void setReportingManager(String reportingManager) {
        this.rm = reportingManager;
    }
}