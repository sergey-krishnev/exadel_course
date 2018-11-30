package jpa.FileDataReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ScvReader {
    private String nameFile;
    private Integer sizeFile;
    private List<String> names = new ArrayList<>();
    private List<String> messages = new ArrayList<>();
    private List<java.sql.Date> datesSending = new ArrayList<>();
    private List<Integer> usersId = new ArrayList<>();
    private List<Integer> topicsId = new ArrayList<>();

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public Integer getSizeFile() {
        return sizeFile;
    }

    public void setSizeFile(Integer sizeFile) {
        this.sizeFile = sizeFile;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Date> getDatesSending() {
        return datesSending;
    }

    public void setDatesSending(List<Date> datesSending) {
        this.datesSending = datesSending;
    }

    public List<Integer> getUsersId() {
        return usersId;
    }

    public void setUsersId(List<Integer> usersId) {
        this.usersId = usersId;
    }

    public List<Integer> getTopicsId() {
        return topicsId;
    }

    public void setTopicsId(List<Integer> topicsId) {
        this.topicsId = topicsId;
    }

    public ScvReader(String nameFile) {
        List<String> dataSubject = null;
        try {
            dataSubject = Files.readAllLines(Paths.get(nameFile), StandardCharsets.UTF_8);
            for (Integer i = 0; i < dataSubject.size(); i++) {
                String[] splitLineSubject = dataSubject.get(i).split(" ; ");
                this.names.add(splitLineSubject[0]);
                this.messages.add(splitLineSubject[1]);
                this.datesSending.add(stringAsDate(splitLineSubject[2]));
                this.usersId.add(Integer.valueOf(splitLineSubject[3]));
                this.topicsId.add(Integer.valueOf(splitLineSubject[4]));
            }
            this.nameFile = nameFile;
            this.sizeFile = dataSubject.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static java.sql.Date stringAsDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  new java.sql.Date(date.getTime());
    }

    @Override
    public String toString() {
        return "ScvReader{" +
                "nameFile='" + nameFile + '\'' +
                ", sizeFile=" + sizeFile +
                ", names=" + names +
                ", messages=" + messages +
                ", datesSending=" + datesSending +
                ", usersId=" + usersId +
                ", topicsId=" + topicsId +
                '}';
    }
}
