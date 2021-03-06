package com.hibernate.hpower.essentialExamples.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Flat_many_to_one {
    @Id
    private int flatId;
    private String apartmentName;
    private String flatNo;
    private int noOfBedrooms;
    @ManyToOne
    private Employee_one_to_many employee;

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public void setEmployee(Employee_one_to_many employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "flatId=" + flatId +
                ", apartmentName='" + apartmentName + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", noOfBedrooms=" + noOfBedrooms +
                '}';
    }
}
