package hibernate.Implementations;

import com.servlet.MainServlet;
import hibernate.Exceptions.MyBatchException;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.FileDataReader.ScvReader;
import hibernate.Interfaces.IDisplay;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AllSubjectDisplayImpl implements IDisplay {

    final static Logger log = Logger.getLogger(MainServlet.class);

    @Override
    public void display(List<Subject> list) {

    }

    @Override
    public List<String> displayToListString(List<Subject> list) {
        return null;
    }

    @Override
    public List<String> displayAll() {

        List<String> s = new ArrayList<>();

        try {

        ScvReader scvReader = new ScvReader("DataSubjects.csv");

        Integer PARAM_CONFIGURATION = 10;

        ISearch searchBy = new SearchImpl();

        ISearch searchByBuilder = new SearchBuilderImpl();

        IDisplay displayBy = new DisplayImpl();

        s.add("OUTPUT USING HQL:");

        s.add("SEARCH BY SUBJECT:");

        s.addAll(displayBy.displayToListString(searchBy.searchBySubject("Capitals")));

        s.add("SEARCH BY USER:");

        s.addAll(displayBy.displayToListString(searchBy.searchByUserId(107)));

        s.add("SEARCH BY USER AND DATE:");

        s.addAll(displayBy.displayToListString(searchBy.searchByUserIdAndDate(107, StringAsDate("2017-11-23"))));

        s.add("SEARCH BY WORD IN MESSAGE:");

        s.addAll(displayBy.displayToListString(searchBy.searchByWordMessage("%co%")));

        s.add("UPDATE BY USER:");

        searchBy.updateMessageByUserId(103);

        s.addAll(displayBy.displayToListString(searchBy.searchAll()));

        s.add("DELETE BY USER:");

        searchBy.deleteMessageByUserId(103);

        s.addAll(displayBy.displayToListString(searchBy.searchAll()));

        s.add("INSERT NEW OBJECTS USING BATCH:");

        searchBy.batchInsertSubject(scvReader, PARAM_CONFIGURATION);

        s.addAll(displayBy.displayToListString(searchBy.searchAll()));

        return s;

        } catch (MyBatchException e) {
            log.error("Hibernate error : " + e.getMessage(), e);
       }
// finally {
//            if (HibernateSessionFactory.getSessionFactory().openSession().isOpen()) HibernateSessionFactory.shutdown();
//        }

//
//            out.println("\n Search by subject ignore register");
//
//            out.println(displayBy.displayToListString(searchBy.searchBySubjectIgnoreRegister("тема")));

//            out.println("Search by user");
//
//            out.println(displayBy.displayToListString(searchBy.searchByUserId(107)));
//
//            out.println("Search by user and date");
//
//            out.println(displayBy.displayToListString(searchBy.searchByUserIdAndDate(107, StringAsDate("2017-11-23"))));
//
//            out.println("Search by word in message");
//
//            out.println(displayBy.displayToListString(searchBy.searchByWordMessage("%co%")));
//
//            out.println("Update by user");
//
//            searchBy.updateMessageByUserId(103);
//
//            out.println(displayBy.displayToListString(searchBy.searchAll()));
//
//            out.println("Delete by user");
//
//            searchBy.deleteMessageByUserId(103);
//
//            out.println(displayBy.displayToListString(searchBy.searchAll()));
//
//            out.println("Insert new objects");
        return s;
    }
    private static java.sql.Date StringAsDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  new java.sql.Date(date.getTime());
    }
}
