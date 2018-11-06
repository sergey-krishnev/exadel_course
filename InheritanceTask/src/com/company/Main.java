package com.company;
import com.company.Comparators.FirstLastNameComparator;
import com.company.Comparators.YearComparator;
import com.company.Employee;

import java.math.BigDecimal;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Map<BigDecimal, List<Employee>> staff = new TreeMap<>();
        Map<Integer, List<Employee>> staffSeparatedDepart = new TreeMap<>();

        BigDecimal border = new BigDecimal("1200");
        Random amountStaff = new Random();
        Integer numberAmountStaff = amountStaff.nextInt(100)+1;
        for (Integer i = 0 ; i < numberAmountStaff ; i++) {
            Random randEmployee = new Random();

            String choiceEmployeeOrManager = randomizeEmployeeOrManager();
            BigDecimal choiceSalary = randomizeSalaryEmployee();
            if (choiceEmployeeOrManager == "Manager") choiceSalary = choiceSalary.add(choiceSalary.multiply(generateRandomBigDecimalFromRange(new BigDecimal("0.1"),new BigDecimal("0.3"))));

            Employee employee = new Employee("First"+(randEmployee.nextInt(500)+1),"Last"+(randEmployee.nextInt(500)+1),
                    choiceEmployeeOrManager, randEmployee.nextInt(30)+1970, randEmployee.nextInt(5)+1,
                    choiceSalary);
            employees.add(employee);

            if (!staff.containsKey(employee.getSalary())) {
                staff.put(employee.getSalary(), new ArrayList<>());
            }
            staff.get(employee.getSalary()).add(employee);

            if (!staffSeparatedDepart.containsKey(employee.getDepartment())) {
                staffSeparatedDepart.put(employee.getDepartment(), new ArrayList<>());
            }
            staffSeparatedDepart.get(employee.getDepartment()).add(employee);

        }
        System.out.println("1)Staff sorted by name:");  //1
        Collections.sort(employees, new FirstLastNameComparator());
        for (Employee x : employees)
        {
            x.display();
        }
        System.out.println("2)Employees who have salary more than 1200"); //2
        Collections.sort(employees, new YearComparator());
        for (Employee x : employees)
        {
            if (x.getSalary().compareTo(border) == 1)
            x.display();
        }
        System.out.println("3)Employees who have equal salary"); //3

        for (Map.Entry<BigDecimal,List<Employee> > pair : staff.entrySet())
        {
            BigDecimal key = pair.getKey();
            List<Employee> value = pair.getValue();
            if (value.size()!=1)
            {
                System.out.println(key + ":");
                for (Employee x : value) {
                    x.display();
                }
                System.out.println("Sum of salary of equal employees is:"+ key.multiply(BigDecimal.valueOf(value.size())));
            }
        }
        System.out.println("4)Common salary from each department");

        for (Map.Entry<Integer,List<Employee> > pair : staffSeparatedDepart.entrySet())
        {
            Integer key = pair.getKey();
            List<Employee> value = pair.getValue();
            if (value.size()!=1)
            {
                System.out.println(key + " department");
                BigDecimal sumSalary = new BigDecimal(0);
                for (Employee x : value) {
                    x.display();
                    sumSalary = sumSalary.add(x.getSalary());
                }
                System.out.println("Sum of salary of employees of common department is:" + sumSalary);
            }
        }



    }

    public static BigDecimal randomizeSalaryEmployee() {
        Random randZeroOrOne = new Random();

        if (randZeroOrOne.nextBoolean()) return new BigDecimal("1000");
        else return new BigDecimal("1001");
    }
    public static String randomizeEmployeeOrManager() {
        Random randZeroOrOne = new Random();

        if (randZeroOrOne.nextBoolean()) return "Employee";
        else return "Manager";
    }
    public static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {

        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));

        return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);

    }
}
