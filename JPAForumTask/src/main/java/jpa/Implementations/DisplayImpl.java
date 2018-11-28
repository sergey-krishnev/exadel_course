package jpa.Implementations;

import jpa.Interfaces.IDisplay;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class DisplayImpl implements IDisplay {

    final static Logger logger = Logger.getLogger(DisplayImpl.class);

    public void display(List entityList) {
        for (Object entity : entityList) {
            logger.info(resultAsString(entity));
        }
    }

    private String resultAsString(Object o) {
        if (o instanceof Object[]) {
            return Arrays.asList((Object[]) o).toString();
        } else {
            return String.valueOf(o);
        }
    }
}
