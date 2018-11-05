package com.company.Employee;

import java.math.BigDecimal;

public class ManagerEmployee extends AbstractEmployee{
    public ManagerEmployee(String FirstName,String LastName,String position, int year, int department, BigDecimal Salary ) {
        super(FirstName,LastName,position,year,department,Salary);
    }

    @Override
    public void display() {
        System.out.printf("Manager First Name: %s \t Manager Last Name: %s \t  Manager position: %s \t " +
                        "Manager year: %s \t Manager department: %s \t Manager salary: %s \n",
                super.getFirstName(),super.getLastName(),super.getPosition(),super.getYear(),super.getDepartment(),super.getSalary());
    }
}
