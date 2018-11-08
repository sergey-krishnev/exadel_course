package com.company.Randomizers;

import java.math.BigDecimal;
import java.util.Random;

public class Randomizer {
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
