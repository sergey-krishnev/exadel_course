package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subject")
@NamedQuery(name = "Subject.getAll", query = "SELECT s FROM Subject s")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "message", length = 256, nullable = false)
    private String message;

    @Column(name = "date_sending", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSending;

    public Subject(String name, String message, Date dateSending) {
        this.name = name;
        this.message = message;
        this.dateSending = dateSending;
    }

    public Subject() {
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

    public long getId() {
        return id;
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
