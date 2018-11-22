package com.company.Implementations;

import com.company.Interfaces.ISearch;

import java.sql.*;
import org.apache.log4j.Logger;

public class SearchImpl implements ISearch {

    final static Logger logger = Logger.getLogger(SearchImpl.class);

    @Override
    public void searchBySubject(String s) throws SQLException {
        String selectSQL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending " +
                "FROM forum_schema.subject " +
                "INNER JOIN forum_schema.users ON subject.user_id = users.id " +
                "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id " +
                "WHERE subject.name = ?;" ;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1,s);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                logger.info(rs.getString("nickname") + " : " + rs.getString("topic_name") + " : " +  rs.getString("subject_name") + " : " +
                        rs.getString("message") + " : " + rs.getString("date_sending"));
            }
        }

    }

    @Override
    public void searchByUserId(Integer u) throws SQLException {
        String selectSQL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending \n" +
                "FROM forum_schema.subject " +
                "INNER JOIN forum_schema.users ON subject.user_id = users.id " +
                "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id " +
                "WHERE subject.user_id = ?;";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1,u);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                logger.info(rs.getString("nickname") + " : " + rs.getString("topic_name") + " : " +  rs.getString("subject_name") + " : " +
                        rs.getString("message") + " : " + rs.getString("date_sending"));
            }
        }
    }

    @Override
    public void searchByUserIdAndDate(Integer u, String date) throws SQLException {
        String selectSQL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending \n" +
                "FROM forum_schema.subject\n" +
                "INNER JOIN forum_schema.users ON subject.user_id = users.id\n" +
                "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id\n" +
                "WHERE subject.user_id = ? \n" +
                "AND subject.date_sending = ?;";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1,u);
            preparedStatement.setDate(2, Date.valueOf(date));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                logger.info(rs.getString("nickname") + " : " + rs.getString("topic_name") + " : " +  rs.getString("subject_name") + " : " +
                        rs.getString("message") + " : " + rs.getString("date_sending"));
            }
        }
    }

    @Override
    public void searchByWordMessage(String w) throws SQLException {
        String selectSQL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending \n" +
                "FROM forum_schema.subject\n" +
                "INNER JOIN forum_schema.users ON subject.user_id = users.id\n" +
                "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id\n" +
                "WHERE subject.message LIKE ?;";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1,w);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                logger.info(rs.getString("nickname") + " : " + rs.getString("topic_name") + " : " +  rs.getString("subject_name") + " : " +
                        rs.getString("message") + " : " + rs.getString("date_sending"));
            }
        }
    }
}
