package com.hibernate.hpower.essentialExamples.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee_one_to_one {
    @Id
    private int empId;
    private String empName;
    private String empAddress;
    @OneToOne
    private Flat_many_to_one flatManytoone;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setFlat(Flat_many_to_one flatManytoone) {
        this.flatManytoone = flatManytoone;
    }

    public Flat_many_to_one getFlat() {
        return flatManytoone;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
