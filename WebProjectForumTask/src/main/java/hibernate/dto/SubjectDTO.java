package hibernate.dto;

import java.util.List;
import java.util.regex.Pattern;

public class SubjectDTO {
    private int id;
    private String subjectName;
    private String description;
    private String userName;
    private String date;
    private List<CommentDTO> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(List<CommentDTO> comments) {
        if (!(comments.isEmpty())) {
            String firstComment = comments.get(0).getMessage();
            this.description = firstComment.split(Pattern.quote("."))[0];
        } else this.description = "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}


