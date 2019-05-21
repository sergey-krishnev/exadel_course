package org.swingtask.factories;

import org.swingtask.utils.BubbleSorting;
import org.swingtask.utils.HeapSorting;
import org.swingtask.utils.MergeSorting;
import org.swingtask.utils.Sorting;

public class SortFactory {

    public Sorting getSorting(String type) {
        if (type.equals("Bubble Sorting")) {
            return new BubbleSorting();
        } else if (type.equals("Heap Sorting")) {
            return new HeapSorting();
        } else if (type.equals("Merge Sorting")) {
            return new MergeSorting();
        }
        return null;
    }

}
