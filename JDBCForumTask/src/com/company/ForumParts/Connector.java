package com.company.ForumParts;

import com.company.Exceptions.MyJdbcException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    final static Logger logger = Logger.getLogger(Connector.class);

    public static Connection connect() {
        Connection dmConnection = null;
        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            logger.warn("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
        }
        try {
            dmConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/foru", "postgres", "postgres");
            return dmConnection;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new MyJdbcException(e.getMessage());
        }
    }
}
