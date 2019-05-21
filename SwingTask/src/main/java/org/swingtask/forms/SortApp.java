package org.swingtask.forms;

import org.swingtask.entities.Student;
import org.swingtask.factories.SortFactory;
import org.swingtask.sorting.Sorting;
import org.swingtask.swing.EntityTableModel;
import org.swingtask.utils.*;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class SortApp {



    private JButton sortButton;

    private JPanel panelMain;

    private JTable tableStudent;

    private JComboBox sortType;

    private JButton save;

    private JCheckBox descOrder;

    private JButton selectButton;

    private List<Student> students;

    public SortApp() {
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortFactory<Student> sortFactory = new SortFactory<>();
                Sorting sorting = sortFactory.getSorting((String) sortType.getSelectedItem());
                sorting.sort(students);
                if (descOrder.isSelected()) {
                    Collections.reverse(students);
                }

                Object[][] matrix = ListConverter.getMatrix(students);
                String[] titles = ListConverter.getFieldNames(students);
                tableStudent.setModel(new EntityTableModel(titles,matrix));
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter<Student> studentFileWriter = new FileWriterImpl<>();
                studentFileWriter.write(panelMain,students);

            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = jfc.showOpenDialog(panelMain);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    System.out.println(selectedFile.getAbsolutePath());
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
        Object[][] studentMatrix = ListConverter.getMatrix(students);
        String[] titles = ListConverter.getFieldNames(students);
        tableStudent = new JTable(new EntityTableModel(titles,studentMatrix));
        sortType = new JComboBox();
        sortType.addItem("Bubble Sorting");
        sortType.addItem("Heap Sorting");
        sortType.addItem("Merge Sorting");
    }
}
