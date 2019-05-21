package org.swingtask.utils;

import org.swingtask.entities.Student;

import java.util.List;

public class BubbleSorting implements Sorting {
    @Override
    public void sort(List<Student> students) {
        {
            int n = students.size();
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (students.get(j).getPerformance() > students.get(j+1).getPerformance())
                    {
                        Student temp = students.get(j);
                        students.set(j,students.get(j+1));
                        students.set(j+1, temp);
                    }
        }
    }
}
