package com.company.Implementations;

import com.company.Interfaces.ISearch;

import java.sql.*;

public class SearchImpl implements ISearch {

    @Override
    public void searchBySubject() throws SQLException {
        String selectSQL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending " +
                "FROM forum_schema.subject " +
                "INNER JOIN forum_schema.users ON subject.user_id = users.id " +
                "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id " +
                "WHERE subject.name = 'Capitals';" ;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "postgres");
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println(rs.getString("nickname") + " : " + rs.getString("topic_name") + " : " +  rs.getString("subject_name") + " : " +
                        rs.getString("message") + " : " + rs.getString("date_sending"));
            }
        }

    }

    @Override
    public void searchByUser() throws SQLException {
        String selectSQL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending \n" +
                "FROM forum_schema.subject\n" +
                "INNER JOIN forum_schema.users ON subject.user_id = users.id\n" +
                "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id\n" +
                "WHERE subject.user_id = 107;";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "postgres");
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println(rs.getString("nickname") + " : " + rs.getString("topic_name") + " : " +  rs.getString("subject_name") + " : " +
                        rs.getString("message") + " : " + rs.getString("date_sending"));
            }
        }
    }

    @Override
    public void searchByUserAndDate() throws SQLException {
        String selectSQL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending \n" +
                "FROM forum_schema.subject\n" +
                "INNER JOIN forum_schema.users ON subject.user_id = users.id\n" +
                "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id\n" +
                "WHERE subject.user_id = 107 \n" +
                "AND subject.date_sending = '2017-11-23';";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "postgres");
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println(rs.getString("nickname") + " : " + rs.getString("topic_name") + " : " +  rs.getString("subject_name") + " : " +
                        rs.getString("message") + " : " + rs.getString("date_sending"));
            }
        }
    }

    @Override
    public void searchByWordMessage() throws SQLException {
        String selectSQL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending \n" +
                "FROM forum_schema.subject\n" +
                "INNER JOIN forum_schema.users ON subject.user_id = users.id\n" +
                "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id\n" +
                "WHERE subject.message LIKE '%co%';";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum", "postgres", "postgres");
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println(rs.getString("nickname") + " : " + rs.getString("topic_name") + " : " +  rs.getString("subject_name") + " : " +
                        rs.getString("message") + " : " + rs.getString("date_sending"));
            }
        }
    }
}
