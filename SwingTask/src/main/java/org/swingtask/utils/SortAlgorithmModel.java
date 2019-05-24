package org.swingtask.utils;

import org.swingtask.factories.EnumSort;

import javax.swing.*;

public class SortAlgorithmModel extends DefaultComboBoxModel<String> {
    public SortAlgorithmModel(EnumSort[] items) {
        for (EnumSort enumSort : items) {
            addElement(enumSort.name());
        }
    }

    @Override
    public String getSelectedItem() {
        return (String) super.getSelectedItem();
    }
}
