package org.swingtask.utils;

import org.swingtask.sorting.Sorting;

import java.util.List;

public class TimeCounterImpl implements TimeCounter {
    @Override
    public long count(List<?> entities, Sorting sorting, boolean descOrder) {
        long startTime =System.nanoTime();
        sorting.sort(entities,descOrder);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }
}
