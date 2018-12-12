package hibernate.Interfaces;

import hibernate.Subject;

import java.util.List;

public interface IDisplay {
    void display(List<Subject> list);

    List<String> displayToListString(List<Subject> list);

    List<String> displayAll(String choice);
}
