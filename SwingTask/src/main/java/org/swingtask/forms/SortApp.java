package org.swingtask.forms;

import org.swingtask.entities.Student;
import org.swingtask.factories.EnumSort;
import org.swingtask.factories.SortFactory;
import org.swingtask.sorting.Sorting;
import org.swingtask.swing.EntityTableModel;
import org.swingtask.utils.*;

import javax.swing.*;
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
            Sorting sorting = sortFactory.getSorting(EnumSort.getByName((String)sortType.getSelectedItem()));

            TimeCounter timeCounter = new TimeCounterImpl();
            timeCount.setText(timeCounter.count(students,sorting,descOrder.isSelected()) + " nanosecond, number of records = " + students.size());

            tableStudent.setModel(new EntityTableModel(students));
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
        String fileName = "students.txt";
        students = fileReader.read(fileName);
        tableStudent = new JTable(new EntityTableModel(students));
        sortType = new JComboBox<>(new SortAlgorithmModel(EnumSort.values()));
    }
}
