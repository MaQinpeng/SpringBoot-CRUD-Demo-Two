package com.littlema.forspringboot.bean;

import org.springframework.stereotype.Component;


public class Employee {
    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id!=null)
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String name;
    private boolean gender;
    private String employeeCode;
    private String email;
    private String country;

    public boolean isGender() {
        return gender;
    }

    public Employee(){}

    public Employee(String name, boolean gender, String employeeCode, String email, String country) {
        this.name = name;
        this.gender = gender;
        this.employeeCode = employeeCode;
        this.email = email;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return country;
    }

    public void setAddress(String address) {
        this.country = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", email='" + email + '\'' +
                ", address='" + country + '\'' +
                '}';
    }
}
