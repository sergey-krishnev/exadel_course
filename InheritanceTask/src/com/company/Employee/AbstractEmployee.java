package com.company.Employee;

import java.math.BigDecimal;

public abstract class AbstractEmployee {
    private String firstName, lastName, position;
    private int year, department;
    private BigDecimal salary;


    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPosition() {
        return position;
    }
    public int getYear() {
        return year;
    }
    public int getDepartment() {
        return department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public AbstractEmployee(String firstName, String lastName, String position, int year, int department, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.year = year;
        this.department = department;
        this.salary = salary;
    }

    public abstract void display();
}
