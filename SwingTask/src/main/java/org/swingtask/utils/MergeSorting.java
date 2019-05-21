package org.swingtask.utils;

import org.swingtask.entities.Student;

import java.util.Arrays;
import java.util.List;

public class MergeSorting implements Sorting {
    @Override
    public void sort(List<Student> students) {

        Student[] arrStudent = new Student[students.size()];
        students.toArray(arrStudent);

        mergeSort(arrStudent, arrStudent.length);

        students.clear();
        students.addAll(Arrays.asList(arrStudent));



    }

    private static void mergeSort(Student[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Student[] l = new Student[mid];
        Student[] r = new Student[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    private static void merge(
            Student[] a, Student[] l, Student[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].getPerformance() <= r[j].getPerformance()) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}
