package hibernate.dao.implementations;

import hibernate.dao.interfaces.DisplayDao;
import hibernate.model.Subject;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.List;

public class DisplayDaoImpl implements DisplayDao {

    final static Logger logger = Logger.getLogger(DisplayDaoImpl.class);
    private static SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");

    @Override
    public void display(List<Subject> entityList) {
        for (Subject entity : entityList) {
            logger.info(String.format(" %-15s | %-25s | %-70s | %-175s | %-10s ",entity.getUsers().getNickname(),
                    entity.getTopic().getName(), entity.getName(),
                    entity.getMessage(),df.format(entity.getDateSending())));
        }
    }
}
