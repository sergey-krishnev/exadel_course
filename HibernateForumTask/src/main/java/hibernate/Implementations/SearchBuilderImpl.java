package hibernate.Implementations;

import hibernate.FileDataReader.ScvReader;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;

import java.sql.Date;
import java.util.List;

public class SearchBuilderImpl implements ISearch {
    @Override
    public List<Subject> searchBySubject(String s) {
        return null;
    }

    @Override
    public List<Subject> searchByUserId(Integer u) {
        return null;
    }

    @Override
    public List<Subject> searchByUserIdAndDate(Integer u, Date d) {
        return null;
    }

    @Override
    public List<Subject> searchByWordMessage(String w) {
        return null;
    }

    @Override
    public List<Subject> searchAll() {
        return null;
    }

    @Override
    public void updateMessageByUserId(Integer u) {

    }

    @Override
    public void deleteMessageByUserId(Integer u) {

    }

    @Override
    public void batchInsertSubject(ScvReader scvReader, Integer numConf) {

    }
}
