package com.pact.poc;

/**
 * Created by Yuvaraj on 26/01/2018.
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String empId;

    public String getID1() {
        return ID1;
    }

    public void setId(String id) {
        this.ID1 = id;
    }

    private String ID1;
    private String department;
}
