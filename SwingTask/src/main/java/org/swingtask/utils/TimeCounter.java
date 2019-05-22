package org.swingtask.utils;

import org.swingtask.sorting.Sorting;

import java.util.List;

public interface TimeCounter {

    long count(List<?> entities, Sorting sorting, boolean descOrder);

}
