package hibernate.dto;

public class ForumDTO {
    private int id;
    private String topicName;
    private Integer numSubjects;
    private Integer numMessages;
    private String lastDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getNumSubjects() {
        return numSubjects;
    }

    public void setNumSubjects(Integer numSubjects) {
        this.numSubjects = numSubjects;
    }

    public Integer getNumMessages() {
        return numMessages;
    }

    public void setNumMessages(Integer numMessages) {
        this.numMessages = numMessages;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
}
