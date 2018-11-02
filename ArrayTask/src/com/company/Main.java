package com.company;
import java.util.ArrayList;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> FirstArray = new  ArrayList<>();
        FirstArray = randomizeArray(FirstArray); //1
        ArrayList<Integer> EvenArray = getEvenArray(FirstArray);  //even array 2
        ArrayList<Integer> OddArray = getOddArray(FirstArray);    //odd array 2
        long SumEvenArray = getSumArray(EvenArray); //3
        long ProductOddArray = getProductArray(OddArray); //4
        ArrayList<Integer> ThirdArray = arraysMultiplier(EvenArray,OddArray); // 5

        System.out.println("First list:");
        System.out.println(FirstArray);
        System.out.println("Even list:");
        System.out.println(EvenArray);
        System.out.println("Odd list:");
        System.out.println(OddArray);
        System.out.println("Sum of elements of even list:" + SumEvenArray);
        System.out.println("Product of elements of odd list:" + ProductOddArray);
        System.out.println("Multiplication the elements of arrays with the same index:");
        System.out.println(ThirdArray);
    }
    private static ArrayList<Integer> randomizeArray(ArrayList<Integer> array) {
        for (int i = 0; i < 1000; i++) {
            Random randInt = new Random();
            array.add(randInt.nextInt(1000));
        }
        return array;
    }
    private static ArrayList<Integer> getEvenArray(ArrayList<Integer> array) {
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.size(); i++)
        {
            Integer x = array.get(i);
            if (x % 2 == 0)    //if x - even
                even.add(x);   // add x in collection of even numbers
        }
        return even;
    }
    private static ArrayList<Integer> getOddArray(ArrayList<Integer> array) {
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i < array.size(); i++)
        {
            Integer x = array.get(i);
            if (x % 2 != 0)    //if x - odd
                odd.add(x);    //add x in collection of odd numbers
        }
        return odd;
    }
    private static long getSumArray(ArrayList<Integer> array) {
        long sum = 0;
        for (int x: array) {
            sum += x;
        }
        return sum;
    }
    private static long getProductArray(ArrayList<Integer> array) {
        long prod = 1;
        for (int x: array) {
            prod *= x;
        }
        return prod;
    }
    private static ArrayList<Integer> arraysMultiplier(ArrayList<Integer> arrayFirst, ArrayList<Integer> arraySecond) {
        ArrayList<Integer> multiArray = new ArrayList<>();
        if (arrayFirst.size() < arraySecond.size()) {
            System.out.println("Second list more than first");
            System.out.println("Calculation with cut second list");
            for (int i = 0; i < arrayFirst.size();i++)
                multiArray.add(arrayFirst.get(i)*arraySecond.get(i));
        }
        if (arrayFirst.size() > arraySecond.size()) {
            System.out.println("First list more than second");
            System.out.println("Calculation with cut first list");
            for (int i = 0; i < arraySecond.size();i++)
                multiArray.add(arrayFirst.get(i)*arraySecond.get(i));
        }
        if (arrayFirst.size() == arraySecond.size()) {
            System.out.println("Size of first and second list are equal");
            System.out.println("Calculation");
            for (int i = 0; i < arraySecond.size();i++)
                multiArray.add(arrayFirst.get(i)*arraySecond.get(i));
        }
        return multiArray;
    }
}
