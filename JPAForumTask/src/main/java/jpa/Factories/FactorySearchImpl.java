package jpa.Factories;

import jpa.Implementations.SearchBuilderImpl;
import jpa.Implementations.SearchImpl;
import jpa.Interfaces.ISearch;

public class FactorySearchImpl {
    public ISearch getSearchImpl(Integer i) {
                if (i == 0) return new SearchImpl();
                else return new SearchBuilderImpl();
            }
    }
