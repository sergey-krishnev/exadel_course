package org.swingtask.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListConverter {

    public static <T> Object[][] getMatrix(List<T> entities) {

        if (entities.isEmpty()) {
            return new Object[0][2];
        }

        Object[][] matrix = new Object[entities.size()][2];
        int i = 0;
        for (T entity : entities) {
            matrix[i++] = objectToArray(entity);
        }
        return matrix;
    }

    public static <T> String[] objectToArray(T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        int entityLength = fields.length;
        String[] arr = new String[entityLength];

        for (int i = 0 ; i < entityLength ; i++) {
            try {
                fields[i].setAccessible(true);
                arr[i] = fields[i].get(entity).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    public static <T> String[] getFieldNames(List<T> entities) {

        if (entities.isEmpty()) return new String[2];

        List<Field> fields = Arrays.asList(entities.get(0).getClass().getDeclaredFields());
        return fields.stream().map(Field::getName).collect(Collectors.toList()).toArray(new String[fields.size()]);
    }



}
