package org.swingtask.utils;

import org.swingtask.entities.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderImpl implements FileReader {

    @Override
    public List<Student> read(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File configFile = new File(classLoader.getResource(fileName).getFile());

        Scanner s = null;
        ArrayList<Student> list = new ArrayList<>();
        try {
            s = new Scanner(configFile);
            while (s.hasNext()) {
                String line = s.next();
                list.add(new Student(line.split(",")[0], Float.parseFloat(line.split(",")[1])));
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
