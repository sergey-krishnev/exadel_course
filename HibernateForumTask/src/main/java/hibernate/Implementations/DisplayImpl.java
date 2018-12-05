package hibernate.Implementations;

import hibernate.Interfaces.IDisplay;
import hibernate.Subject;

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


}
