package com.company;
import com.company.Comparators.FirstLastNameComparator;
import com.company.Comparators.YearComparator;
import com.company.Employee;
import com.company.Randomizers.Randomizer;

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
        fillingCollections(numberAmountStaff, employees, staff, staffSeparatedDepart);

        //Output of task
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
    public static void fillingCollections(Integer numbAmSt, List<Employee> empl, Map<BigDecimal, List<Employee>> st, Map<Integer, List<Employee>> stSepDep) {
        for (Integer i = 0 ; i < numbAmSt ; i++) {
            Random randEmployee = new Random();
            String choiceEmployeeOrManager = Randomizer.randomizeEmployeeOrManager();
            BigDecimal choiceSalary = Randomizer.randomizeSalaryEmployee();
            if (choiceEmployeeOrManager == "Manager") choiceSalary = choiceSalary.add(choiceSalary.multiply(Randomizer.generateRandomBigDecimalFromRange(new BigDecimal("0.1"),new BigDecimal("0.3"))));

            Employee employee = new Employee("First"+(randEmployee.nextInt(500)+1),"Last"+(randEmployee.nextInt(500)+1),
                    choiceEmployeeOrManager, randEmployee.nextInt(30)+1970, randEmployee.nextInt(5)+1,
                    choiceSalary);
            empl.add(employee);

            if (!st.containsKey(employee.getSalary())) {
                st.put(employee.getSalary(), new ArrayList<>());
            }
            st.get(employee.getSalary()).add(employee);

            if (!stSepDep.containsKey(employee.getDepartment())) {
                stSepDep.put(employee.getDepartment(), new ArrayList<>());
            }
            stSepDep.get(employee.getDepartment()).add(employee);
        }
    }

}
