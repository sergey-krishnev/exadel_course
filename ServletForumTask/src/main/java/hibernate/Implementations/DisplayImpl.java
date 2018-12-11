package hibernate.Implementations;

import hibernate.Interfaces.IDisplay;
import hibernate.Subject;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;

public class DisplayImpl implements IDisplay {

    final static Logger logger = Logger.getLogger(DisplayImpl.class);
    private static SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");

    public void display(List<Subject> entityList) {
        for (Subject entity : entityList) {
            logger.info(entity.getUsers().getNickname() + "|" + entity.getTopic().getName() + "|" + entity.getName() +
                    "|" + entity.getMessage() + "|" + df.format(entity.getDateSending()));
        }
    }

    @Override
    public List<String> displayToListString(List<Subject> entityList) {
        List<String> display = new ArrayList<>();
        for (Subject entity : entityList) {
        display.add(String.format(" %-15s | %-25s | %-70s | %-175s | %-10s ",entity.getUsers().getNickname(),
                entity.getTopic().getName(), entity.getName(),
                entity.getMessage(),df.format(entity.getDateSending())));
        }
        return display;
    }

    @Override
    public List<String> displayAll(String choice) {
        return null;
    }

}
