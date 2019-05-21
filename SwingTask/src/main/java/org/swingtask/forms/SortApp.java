package org.swingtask.forms;

import org.swingtask.entities.Student;
import org.swingtask.factories.SortFactory;
import org.swingtask.swing.StudentTableModel;
import org.swingtask.utils.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortApp {



    private JButton sortButton;
    private JPanel panelMain;
    private JTable tableStudent;
    private JComboBox sortType;
    private JButton save;
    private List<Student> students;

    public SortApp() {
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortFactory sortFactory = new SortFactory();
                Sorting sorting = sortFactory.getSorting((String) sortType.getSelectedItem());
                sorting.sort(students);

                Object[][] studentMatrix = ListConverter.convert(students);
                List<Field> fields = Arrays.asList(Student.class.getDeclaredFields());
                String[] titles = fields.stream().map(Field::getName).collect(Collectors.toList()).toArray(new String[fields.size()]);
                tableStudent.setModel(new StudentTableModel(titles,studentMatrix));
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to save");

                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
                fileChooser.setFileFilter(filter);

                int userSelection = fileChooser.showSaveDialog(panelMain);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                    List<String> viewStudents = students.stream().map(Student::toString).collect(Collectors.toList());
                    try {
                        Files.write(Paths.get(fileToSave.getAbsolutePath()), viewStudents);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
    }

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("SortApp");
        jFrame.setContentPane(new SortApp().panelMain);
        jFrame.setPreferredSize(new Dimension(500, 200));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private void createUIComponents() {
        FileReader fileReader = new FileReaderImpl();
        students = fileReader.read("students.txt");
        Object[][] studentMatrix = ListConverter.convert(students);
        List<Field> fields = Arrays.asList(Student.class.getDeclaredFields());
        String[] titles = fields.stream().map(Field::getName).collect(Collectors.toList()).toArray(new String[fields.size()]);
        tableStudent = new JTable(new StudentTableModel(titles,studentMatrix));
        sortType = new JComboBox();
        sortType.addItem("Bubble Sorting");
        sortType.addItem("Heap Sorting");
        sortType.addItem("Merge Sorting");
    }
}
