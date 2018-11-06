package com.company.Comparators;

import com.company.Employee;

import java.util.Comparator;

public class FirstLastNameComparator implements Comparator<Employee> {
    public int compare(Employee a, Employee b){

        return a.getFirstName().compareTo(b.getFirstName());
    }
}
