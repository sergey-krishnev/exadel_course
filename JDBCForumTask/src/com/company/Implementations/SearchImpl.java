package com.company.Implementations;

import com.company.ForumParts.Connector;
import com.company.ForumParts.Results;
import com.company.Interfaces.ISearch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchImpl implements ISearch {
    private static String SELECT_SQL_ALL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending " +
            "FROM forum_schema.subject " +
            "INNER JOIN forum_schema.users ON subject.user_id = users.id " +
            "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id ";

    private static String SELECT_SQL_NAME =  SELECT_SQL_ALL + "WHERE subject.name = ?;";
    private static String SELECT_SQL_USER_ID = SELECT_SQL_ALL + "WHERE subject.user_id = ?;";
    private static String SELECT_SQL_USER_DATE = SELECT_SQL_ALL + "WHERE subject.user_id = ? " +
            "AND subject.date_sending = ?;";
    private static String SELECT_SQL_MESSAGE_LIKE = SELECT_SQL_ALL +
            "WHERE subject.message LIKE ?;";
    private static String UPDATE_SQL_MESSAGE_BY_USER_ID = "UPDATE forum_schema.subject " +
            "SET message = '[Blocked by moderator]' " +
            "WHERE user_id = ?;";

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
    public List<Results> updateMessageByUserId(Integer u) throws SQLException {
        List<Results> resultsList = new ArrayList<>();
        Connection connection = Connector.connect();
        PreparedStatement updatePreparedStatement = null;
        PreparedStatement selectPreparedStatement = null;
        try {
            connection.setAutoCommit(false);
            updatePreparedStatement = connection.prepareStatement(UPDATE_SQL_MESSAGE_BY_USER_ID);
            selectPreparedStatement = connection.prepareStatement(SELECT_SQL_ALL);
            updatePreparedStatement.setInt(1,u);
            updatePreparedStatement.executeUpdate();
            selectPreparedStatement.executeUpdate();
            connection.commit();
            ResultSet rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
                resultsList.add(new Results(rs.getString("nickname"), rs.getString("topic_name"), rs.getString("subject_name"),
                        rs.getString("message"), rs.getDate("date_sending")));
            }
        return resultsList;
        } catch (SQLException e) {
            connection.rollback();
        }
        return resultsList;
    }

    @Override
    public List<Results> deleteMessageByUserId(Integer u) throws SQLException {
        return null;
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

    public void transaction(Connection connection) {

    }

}
