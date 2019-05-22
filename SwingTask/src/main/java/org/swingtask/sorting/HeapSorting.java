package org.swingtask.sorting;

import java.util.List;

public class HeapSorting<T extends Comparable<T>> implements Sorting<T> {
    @Override
    public void sort(List<T> entities, boolean descOrder) {
        int n = entities.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(entities, n, i, descOrder);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            T temp = entities.get(0);
            entities.set(0,entities.get(i));
            entities.set(i,temp);
            // call max heapify on the reduced heap
            heapify(entities, i, 0, descOrder);
        }
    }

    private void heapify(List<T> entities, int n, int i, boolean descOrder) {
        int descValue = (descOrder) ? -1 : 1;
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && (descValue*(entities.get(l).compareTo(entities.get(largest)))) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && (descValue*(entities.get(r).compareTo(entities.get(largest)))) > 0)
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            T swap = entities.get(i);
            entities.set(i,entities.get(largest));
            entities.set(largest,swap);

            // Recursively heapify the affected sub-tree
            heapify(entities, n, largest, descOrder);
        }
    }
}
