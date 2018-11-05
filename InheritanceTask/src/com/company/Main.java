package com.company;
import com.company.Employee.AbstractEmployee;
import com.company.Employee.ManagerEmployee;
import com.company.Employee.StandartEmployee;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        Map staff = new HashMap< Integer, AbstractEmployee>();
        Random amountStaff = new Random();
        for (Integer i = 0 ; i < amountStaff.nextInt(100)+1 ; i++) {
            Random randEmployee = new Random();
            StandartEmployee employee = new StandartEmployee("First"+i,"Last"+i,"Employee",
                    randEmployee.nextInt(48)+1970, randEmployee.nextInt(5)+1,
                    generateRandomBigDecimalFromRange(new BigDecimal("1000"),new BigDecimal("1500")));
            staff.put(i, employee);

        }

        System.out.println(staff);
    }
    public static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
