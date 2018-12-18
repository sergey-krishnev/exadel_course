package hibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "subject", schema = "forum_schema")

public class Subject implements Serializable {
    @Id
    @GeneratedValue(generator = "subject_id__generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="subject_id__generator", sequenceName = "forum_schema.forum_id_subject_seq", allocationSize=1)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date_sending", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
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

    public String getFormattedDateSending() {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        return df.format(dateSending);
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", dateSending=" + dateSending +
                ", users=" + users +
                ", topic=" + topic +
                '}';
    }
}

