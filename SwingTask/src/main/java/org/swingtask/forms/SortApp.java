package org.swingtask.forms;

import org.swingtask.entities.Student;
import org.swingtask.factories.SortFactory;
import org.swingtask.sorting.Sorting;
import org.swingtask.swing.EntityTableModel;
import org.swingtask.utils.*;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class SortApp {



    private JButton sortButton;

    private JPanel panelMain;

    public JPanel getPanelMain() {
        return panelMain;
    }

    private JTable tableStudent;

    private JComboBox<String> sortType;

    private JButton save;

    private JCheckBox descOrder;

    private JLabel timeCount;

    private List<Student> students;



    public SortApp() {
        sortButton.addActionListener(e -> {
            SortFactory<Student> sortFactory = new SortFactory<>();
            Sorting sorting = sortFactory.getSorting((String) sortType.getSelectedItem());

            TimeCounter timeCounter = new TimeCounterImpl();
            timeCount.setText(timeCounter.count(students,sorting,descOrder.isSelected()) + " nanosecond, number of records = " + students.size());

            Object[][] matrix = ListConverter.getMatrix(students);
            String[] titles = ListConverter.getFieldNames(students);
            tableStudent.setModel(new EntityTableModel(titles,matrix));
        });
        save.addActionListener(e -> {
            FileWriter<Student> studentFileWriter = new FileWriterImpl<>();
            studentFileWriter.write(panelMain,students);

        });
    }

    public static void main(String[] args) {
        JFrameInitializer.initialize();
    }

    private void createUIComponents() {

        FileReader fileReader = new FileReaderImpl();
        students = fileReader.read("students.txt");
        Object[][] studentMatrix = ListConverter.getMatrix(students);
        String[] titles = ListConverter.getFieldNames(students);
        tableStudent = new JTable(new EntityTableModel(titles,studentMatrix));
        sortType = new JComboBox<>();
        sortType.addItem("Bubble Sorting");
        sortType.addItem("Heap Sorting");
        sortType.addItem("Merge Sorting");
    }
}
