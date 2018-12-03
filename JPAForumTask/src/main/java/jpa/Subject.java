package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "subject", schema = "forum_schema")

@NamedQueries({
        @NamedQuery(name = "findAll",
                query = "SELECT s FROM Subject s"),

        @NamedQuery(name = "findBySubject",
                query = "SELECT s FROM Subject s " +
                "WHERE s.name = :name"),

        @NamedQuery(name = "findById",
                query = "SELECT s FROM Subject s " +
                        "WHERE s.users.id = :id"),

        @NamedQuery(name = "findByUserAndDate",
                query = "SELECT s FROM Subject s " +
                        "WHERE s.users.id = :id AND s.dateSending = :dateSending"),

        @NamedQuery(name = "findByWordMessage",
                query = "SELECT s FROM Subject s " +
                        "WHERE s.message LIKE :message"),

        @NamedQuery(name = "updateMessageById",
                query = "UPDATE Subject s SET s.message = '[Blocked by moderator]' " +
                        "WHERE s.users.id = :id"),

        @NamedQuery(name = "deleteMessageById",
                query = "DELETE FROM Subject s WHERE s.users.id = :id")
})

public class Subject implements Serializable {
    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date_sending", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateSending;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Subject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateSending() {
        return dateSending;
    }

    public void setDateSending(Date dateSending) {
        this.dateSending = dateSending;
    }



    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Subject(String name, String message, Date dateSending, Users users, Topic topic) {
        this.name = name;
        this.message = message;
        this.dateSending = dateSending;
        this.users = users;
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", dateSending=" + dateSending +
                '}';
    }
}
