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
public class department {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;
    @Column
    private String dname;
    @Column
    private Date cd;

    @Column
    private String dephead;

    public int getId() {
        return did;
    }

    public void setId(int id) {
        this.did = id;
    }

    public String getName() {
        return dname;
    }

    public void setName(String dname) {
        this.dname = dname;
    }

    public String getDepartmenthead() {
        return dephead;
    }

    public void setDepartmenthead(String dephead) {
        this.dephead = dephead;
    }

}
