package com.company.Implementations;

import com.company.Exceptions.MyJdbcException;
import com.company.FileDataReader.ScvReader;
import com.company.ForumParts.Connector;
import com.company.ForumParts.Results;
import com.company.Interfaces.ISearch;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchImpl implements ISearch {
    private final static String SELECT_SQL_ALL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending " +
            "FROM forum_schema.subject " +
            "INNER JOIN forum_schema.users ON subject.user_id = users.id " +
            "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id ";

    private final static String SELECT_SQL_NAME =  SELECT_SQL_ALL + "WHERE subject.name = ?;";
    private final static String SELECT_SQL_USER_ID = SELECT_SQL_ALL + "WHERE subject.user_id = ?;";
    private final static String SELECT_SQL_USER_DATE = SELECT_SQL_ALL + "WHERE subject.user_id = ? " +
            "AND subject.date_sending = ?;";
    private final static String SELECT_SQL_MESSAGE_LIKE = SELECT_SQL_ALL +
            "WHERE subject.message LIKE ?;";
    private final static String UPDATE_SQL_MESSAGE_BY_USER_ID = "UPDATE forum_schema.subject " +
            "SET message = '[Blocked by moderator]' " +
            "WHERE user_id = ?;";
    private final static String DELETE_SQL_MESSAGE_BY_USER_ID ="DELETE FROM forum_schema.subject " +
            "WHERE user_id = ?;";

    private final static String INSERT_SUBJECTS = "INSERT INTO forum_schema.subject (id, name, message, date_sending, user_id, topic_id)" +
            " VALUES (NEXTVAL('forum_id_subject_seq'), ?, ?, ?, ?, ?)";

    private final static Logger logger = Logger.getLogger(Connector.class);

    @Override
    public List<Results> searchBySubject(String subject) throws SQLException {
        List<Results> resultsList = new ArrayList<>();
        preparedStOneSetString(subject, resultsList, SELECT_SQL_NAME);
        return resultsList;
    }

    @Override
    public List<Results> searchByUserId(Integer u) throws SQLException {
        List<Results> resultsList = new ArrayList<>();

        try (Connection connection = Connector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL_USER_ID)) {
            preparedStatement.setInt(1, u);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                resultsList.add(new Results(rs.getString("nickname"), rs.getString("topic_name"), rs.getString("subject_name"),
                        rs.getString("message"), rs.getDate("date_sending")));
            }
        }
        return resultsList;
    }

    @Override
    public List<Results> searchByUserIdAndDate(Integer u, String date) throws SQLException {
        List<Results> resultsList = new ArrayList<>();
        try (Connection connection = Connector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL_USER_DATE)) {
            preparedStatement.setInt(1, u);
            preparedStatement.setDate(2, Date.valueOf(date));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                resultsList.add(new Results(rs.getString("nickname"), rs.getString("topic_name"), rs.getString("subject_name"),
                        rs.getString("message"), rs.getDate("date_sending")));
            }
        }
        return resultsList;
    }

    @Override
    public List<Results> searchByWordMessage(String wordMessage) throws SQLException {
        List<Results> resultsList = new ArrayList<>();
        preparedStOneSetString(wordMessage, resultsList, SELECT_SQL_MESSAGE_LIKE);
        return resultsList;
    }

    @Override
    public List<Results> searchAll() throws SQLException {
        List<Results> resultsList = new ArrayList<>();
        try (Connection connection = Connector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                resultsList.add(new Results(rs.getString("nickname"), rs.getString("topic_name"), rs.getString("subject_name"),
                        rs.getString("message"), rs.getDate("date_sending")));
            }
        }
        return resultsList;
    }

    @Override
    public void updateMessageByUserId(Integer u) throws SQLException {
        preparedStTransactionOneSetInt(u,UPDATE_SQL_MESSAGE_BY_USER_ID);
    }

    @Override
    public void deleteMessageByUserId(Integer u) throws SQLException {
        preparedStTransactionOneSetInt(u,DELETE_SQL_MESSAGE_BY_USER_ID);
    }

//    @Override
//    public void updateAndDeleteMessageByUserId(String u, Integer w) throws SQLException {
//        try (Connection connection = Connector.connect();
//             PreparedStatement updatePreparedStatement = connection.prepareStatement(UPDATE_SQL_MESSAGE_BY_USER_ID);
//             PreparedStatement deletePreparedStatement = connection.prepareStatement(DELETE_SQL_MESSAGE_BY_USER_ID)) {
//             connection.setAutoCommit(false);
//             deletePreparedStatement.setInt(1,w);
//             deletePreparedStatement.executeUpdate();
//             updatePreparedStatement.setString(1,u);
//             updatePreparedStatement.executeUpdate();
//             connection.commit();
//        }
//    }

    @Override
    public void batchInsertSubject(ScvReader scvReader, Integer numConf) throws SQLException {
        try (Connection connection = Connector.connect();
             PreparedStatement insertPreparedStatement = connection.prepareStatement(INSERT_SUBJECTS)) {
            for(int i = 0; i < numConf; i++) {
                insertPreparedStatement.setString(1, scvReader.getNames().get(i));
                insertPreparedStatement.setString(2,  scvReader.getMessages().get(i));
                insertPreparedStatement.setDate(3, scvReader.getDatesSending().get(i));
                insertPreparedStatement.setInt(4, scvReader.getUsersId().get(i));
                insertPreparedStatement.setInt(5, scvReader.getTopicsId().get(i));
                insertPreparedStatement.addBatch();
            }
            insertPreparedStatement.executeBatch();
        }
    }

    public List<Results> preparedStOneSetString(String value, List<Results> resultsList, String selectedSQL) throws SQLException {
        try (Connection connection = Connector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(selectedSQL)) {
            preparedStatement.setString(1, value);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                resultsList.add(new Results(rs.getString("nickname"), rs.getString("topic_name"), rs.getString("subject_name"),
                        rs.getString("message"), rs.getDate("date_sending")));
            }
        }
        return resultsList;
    }

    public void preparedStTransactionOneSetInt(Integer u, String selectedSQL) throws  SQLException {
        try (Connection connection = Connector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(selectedSQL)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, u);
            preparedStatement.executeUpdate();
            connection.commit();
        }
    }


}
