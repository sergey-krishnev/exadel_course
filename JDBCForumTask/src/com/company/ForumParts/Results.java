package com.company.ForumParts;

import java.sql.Date;

public class Results {
    private String nickname;
    private String topicName;
    private String subjectName;
    private String message;
    private Date dateSending;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public java.sql.Date getDateSending() {
        return dateSending;
    }

    public void setDateSending(java.sql.Date dateSending) {
        this.dateSending = dateSending;
    }

    public Results(String nickname, String topicName, String subjectName, String message, java.sql.Date dateSending) {
        this.nickname = nickname;
        this.topicName = topicName;
        this.subjectName = subjectName;
        this.message = message;
        this.dateSending = dateSending;
    }

    @Override
    public String toString() {
        return "Results{" +
                "nickname='" + nickname + '\'' +
                ", topicName='" + topicName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", message='" + message + '\'' +
                ", dateSending=" + dateSending +
                '}';
    }
}
