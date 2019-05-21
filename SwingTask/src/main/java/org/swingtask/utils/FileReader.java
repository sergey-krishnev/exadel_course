package org.swingtask.utils;

import org.swingtask.entities.Student;

import java.util.List;

public interface FileReader {

    List<Student> read(String filename);

}
