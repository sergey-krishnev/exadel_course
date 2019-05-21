package org.swingtask.utils;

import org.swingtask.sorting.Sorting;

import java.util.List;

public class TimeCounterImpl implements TimeCounter {
    @Override
    public long count(List<?> entities, Sorting sorting) {
        long startTime =System.nanoTime();
        sorting.sort(entities);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }
}
