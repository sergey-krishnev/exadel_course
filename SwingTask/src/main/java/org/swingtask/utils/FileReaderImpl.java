package org.swingtask.utils;

import org.swingtask.entities.Student;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileReaderImpl implements FileReader {

    @Override
    public List<Student> read(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();

        Scanner s = null;
        ArrayList<Student> list = new ArrayList<>();
        try {

            URL resourceURL = classLoader.getResource(fileName);
            if (resourceURL == null) {
                throw new FileNotFoundException(fileName + " not found");
            } else {
                File configFile = new File(resourceURL.getFile());
                s = new Scanner(configFile);
                long numLine = 0;
                List<Long> errorLines = new ArrayList<>();
                while (s.hasNext()) {
                    numLine++;
                    String line = s.next();
                    String performance = line.split(",")[1];
                    if (performance.matches("[-+]?([0-9]*\\.[0-9]+|[0-9]+)")) {
                        list.add(new Student(line.split(",")[0], Float.parseFloat(line.split(",")[1])));
                    } else {
                        errorLines.add(numLine);
                    }

                }
                if (!errorLines.isEmpty()) {
                    String message = "\"Validation error in " + fileName + "\"\n"
                            + "in " + errorLines.toString() + " line\n"
                            + "skipped incorrect lines\n";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Oops!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (FileNotFoundException e) {
            String message = fileName + " is not found\"\n"
                    + "please, check the name of file\n";
            JOptionPane.showMessageDialog(new JFrame(), message, "Oops!",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (s != null)
                s.close();
        }


        return list;
    }
}
