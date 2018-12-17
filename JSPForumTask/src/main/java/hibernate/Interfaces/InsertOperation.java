package hibernate.Interfaces;

import org.apache.log4j.Logger;

import java.sql.Date;

public interface InsertOperation {

    void insertSubject(String nickname, String tName, String sName, String message, Date d);

}
