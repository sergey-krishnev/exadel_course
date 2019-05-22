package org.swingtask.factories;

import org.swingtask.sorting.BubbleSorting;
import org.swingtask.sorting.HeapSorting;
import org.swingtask.sorting.MergeSorting;
import org.swingtask.sorting.Sorting;

import java.util.Arrays;

public enum EnumSort {

    BUBBLE("Bubble sort") {
        @Override
        public Sorting getSorting() {
            return new BubbleSorting();
        }
    },
    HEAP("Heap sort") {
        @Override
        public Sorting getSorting() {
            return new HeapSorting();
        }
    },
    MERGE("Merge sort") {
        @Override
        public Sorting getSorting() {
            return new MergeSorting();
        }
    };

    private final String name;

    public String toString() {
        return name;
    }

    public static String[] names() {
        return Arrays.stream(EnumSort.values()).map(n -> n.name).toArray(String[]::new);
    }

    public static EnumSort getByName(String name) {
        return Arrays.stream(EnumSort.values()).filter(v -> v.name.equals(name)).findAny().orElse(null);
    }

    EnumSort(String s) {
        this.name = s;
    }

    public abstract Sorting getSorting();
}
