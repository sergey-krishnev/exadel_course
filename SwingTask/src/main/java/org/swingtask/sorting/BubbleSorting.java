package org.swingtask.sorting;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BubbleSorting<T extends Comparable<T>> implements Sorting<T>{
    @Override
    public void sort(List<T> entities) {

        long startTime =System.nanoTime();

            int n = entities.size();
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (entities.get(j).compareTo(entities.get(j+1)) > 0)
                    {
                        T temp = entities.get(j);
                        entities.set(j,entities.get(j+1));
                        entities.set(j+1, temp);
                    }

        long endTime = System.nanoTime();
        System.out.println(endTime - startTime + " nanosecond");
    }
}
