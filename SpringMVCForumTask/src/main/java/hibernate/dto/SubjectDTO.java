package hibernate.dto;

public class SubjectDTO {
    private String nickname;
    private String topic;
    private String subject;
    private String message;
    private String date;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SubjectDTO(String name, String message, String formattedDateSending) {
    }

    public SubjectDTO() {
    }

    public SubjectDTO(String nickname, String topic, String subject, String message, String date) {
        this.subject = subject;
        this.message = message;
        this.date = date;
    }
}


