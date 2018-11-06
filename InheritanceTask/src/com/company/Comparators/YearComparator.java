package com.company.Comparators;

import com.company.Employee;

import java.util.Comparator;

public class YearComparator implements Comparator<Employee> {
    public int compare(Employee a, Employee b){

        return a.getYear().compareTo(b.getYear());
    }
}
