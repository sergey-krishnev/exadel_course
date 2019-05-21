package org.swingtask.entities;

import java.util.Objects;

public class Student {

    private String name;

    private float performance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPerformance() {
        return performance;
    }

    public void setPerformance(float performance) {
        this.performance = performance;
    }

    public Student(String name, float performance) {
        this.name = name;
        this.performance = performance;
    }

    @Override
    public String toString() {
        return name + ',' + performance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Float.compare(student.performance, performance) == 0 &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, performance);
    }
}
