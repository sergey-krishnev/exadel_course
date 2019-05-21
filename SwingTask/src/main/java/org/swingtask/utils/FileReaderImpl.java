package org.swingtask.utils;

import org.swingtask.entities.Student;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileReaderImpl implements FileReader {

    @Override
    public List<Student> read(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File configFile = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());

        Scanner s = null;
        ArrayList<Student> list = new ArrayList<>();
        try {
            s = new Scanner(configFile);
            long numLine = 0;
            while (s.hasNext()) {
                List<Long> errorLines = new ArrayList<>();
                numLine++;
                String line = s.next();
//                [-+]?([0-9]*\.[0-9]+|[0-9]+)
                String performance = line.split(",")[1];
                if (performance.matches("[-+]?([0-9]*\\.[0-9]+|[0-9]+)")) {
                    list.add(new Student(line.split(",")[0], Float.parseFloat(line.split(",")[1])));
                } else {
                    errorLines.add(numLine);
                }
                if (!errorLines.isEmpty()) {
                    String message = "\"Validation error\"\n"
                            + "in " + errorLines.toString() + " line\n"
                            + "skipped incorrect lines\n";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Oops!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            assert s != null;
            s.close();
        }


        return list;
    }
}
