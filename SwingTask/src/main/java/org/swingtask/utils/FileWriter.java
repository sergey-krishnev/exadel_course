package org.swingtask.utils;

import javax.swing.*;
import java.util.List;

public interface FileWriter<T> {

    void write(JPanel panel, List<T> entities);

}
