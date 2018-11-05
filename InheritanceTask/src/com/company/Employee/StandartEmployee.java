package com.company.Employee;

import java.math.BigDecimal;

public class StandartEmployee extends AbstractEmployee {
    public StandartEmployee(String FirstName,String LastName) {
        super(FirstName,LastName,position,year,department,salary);
    }

    @Override
    public void display() {
        System.out.printf("Employee First Name: %s \t Employee Last Name: %s \t  Employee position: %s \t " +
                        "Employee year: %s \t Employee department: %s \t Employee salary: %s \n",
                super.getFirstName(),super.getLastName(),super.getPosition(),super.getYear(),super.getDepartment(),super.getSalary());
    }
}
