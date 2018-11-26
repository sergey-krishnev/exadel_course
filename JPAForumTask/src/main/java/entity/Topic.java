package entity;

import javax.persistence.*;

@Entity
@Table(name = "topic")
@NamedQuery(name = "Topic.getAll", query = "SELECT t FROM Topic t")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    public Topic(String name) {
        this.name = name;
    }

    public Topic() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                '}';
    }
}
