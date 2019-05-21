package org.swingtask.utils;

import org.swingtask.entities.Student;

import java.util.List;

public class ListConverter {

    public static Object[][] convert(List<Student> students) {

//        Object[][] matrix = new Object[2][students.size()];
//        int i = 0;
//        for (Student student : students) {
//            matrix[i++] = studentToArray(student);
//        }
//
//        return null;
        Object[][] matrix = new Object[students.size()][2];
        int i = 0;
        for (Student student : students) {
            matrix[i++] = objectToArray(student);
        }
        return matrix;
    }

    public static String[] objectToArray(Student student) {
        String[] arr = new String[2];
        arr[0] = student.getName();
        arr[1] = String.valueOf(student.getPerformance());
        return arr;
    }



}
