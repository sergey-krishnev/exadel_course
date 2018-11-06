package com.company;

import java.math.BigDecimal;

public class Employee {
    private String firstName,lastName,position;
    private Integer department,year;
    private BigDecimal salary;

    public Employee(String firstName, String lastName, String position, Integer year, Integer department, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;
        this.year = year;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public void display() {

        System.out.printf("Employee First Name: %s \t Employee Last Name: %s \t  Employee position: %s \t " +

                        "Employee year: %s \t Employee department: %s \t Employee salary: %s \n",

                getFirstName(),getLastName(),getPosition(),getYear(),getDepartment(),getSalary());

    }
}
