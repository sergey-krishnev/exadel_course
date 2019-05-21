package org.swingtask.utils;

import org.swingtask.entities.Student;

import java.util.List;

public class HeapSorting implements Sorting {
    @Override
    public void sort(List<Student> students) {
        int n = students.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(students, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            Student temp = students.get(0);
            students.set(0,students.get(i));
            students.set(i,temp);
            // call max heapify on the reduced heap
            heapify(students, i, 0);
        }
    }

    private void heapify(List<Student> students, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && students.get(l).getPerformance() > students.get(largest).getPerformance())
            largest = l;

        // If right child is larger than largest so far
        if (r < n && students.get(r).getPerformance() > students.get(largest).getPerformance())
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            Student swap = students.get(i);
            students.set(i,students.get(largest));
            students.set(largest,swap);

            // Recursively heapify the affected sub-tree
            heapify(students, n, largest);
        }
    }
}
