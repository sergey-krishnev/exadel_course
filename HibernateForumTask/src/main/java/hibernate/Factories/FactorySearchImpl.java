package hibernate.Factories;

import hibernate.Implementations.SearchBuilderImpl;
import hibernate.Implementations.SearchImpl;
import hibernate.Interfaces.ISearch;

public class FactorySearchImpl {
    public ISearch getSearchImpl(Integer i) {
        if (i == 0) return new SearchImpl();
        else return new SearchBuilderImpl();
    }
}
