package org.swingtask.utils;

import org.swingtask.entities.Student;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileWriterImpl<T> implements FileWriter<T>
{
    @Override
    public void write(JPanel panel, List<T> entities) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(panel);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            List<String> viewStudents = entities.stream().map(T::toString).collect(Collectors.toList());
            try {
                Files.write(Paths.get(fileToSave.getAbsolutePath()), viewStudents);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
}
