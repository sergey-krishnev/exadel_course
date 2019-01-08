package hibernate.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class SubjectDTO {
    private String nickname;
    private String topic;
    @NotEmpty
    private String subject;
    @NotEmpty
    private String message;
    @NotEmpty
    @Pattern(regexp = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])")
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


