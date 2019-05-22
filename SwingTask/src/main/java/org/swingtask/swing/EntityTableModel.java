package org.swingtask.swing;

import org.swingtask.entities.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EntityTableModel extends AbstractTableModel {

    private boolean DEBUG = false;

    private String[] columnNames = {"name", "performance"};

    private Object[][] data;

    private List<Student> entities;

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return entities.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        switch(col)
        {
            case 0:
                return entities.get(row).getName();
            case 1:
                return entities.get(row).getPerformance();
        }
        return new Object();
    }

    public EntityTableModel(String[] columnNames, Object[][] data) {
        this.columnNames = columnNames;
        this.data = data;
    }

    public EntityTableModel(List<Student> entities) {
        this.entities = entities;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 1) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                    + " to " + value
                    + " (an instance of "
                    + value.getClass() + ")");
        }

        data[row][col] = value;
        fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();
        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
