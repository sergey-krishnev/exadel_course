package com.company.Implementations;

import com.company.ForumParts.Results;
import com.company.Interfaces.IDisplay;
import org.apache.log4j.Logger;

import java.util.List;

public class DisplayImpl implements IDisplay {

    final static Logger logger = Logger.getLogger(SearchImpl.class);

    @Override
    public void display(List<Results> results) {
        for (Results result : results ) logger.info(result);
    }

    @Override
    public void display(int[] changed) {
        logger.info(changed);
    }
}
