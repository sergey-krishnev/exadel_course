package org.swingtask.factories;

import org.swingtask.sorting.Sorting;

public class SortFactory<T extends Comparable<T>> {
    //
//    public Sorting getSorting(String type) {
//        if (type.equals("Bubble Sorting")) {
//            return new BubbleSorting<T>();
//        } else if (type.equals("Heap Sorting")) {
//            return new HeapSorting<T>();
//        } else if (type.equals("Merge Sorting")) {
//            return new MergeSorting<T>();
//        }
//        return null;
//    }
//
    public Sorting getSorting(EnumSort enumSort) {
        return enumSort.getSorting();
    }

}

