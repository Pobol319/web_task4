package com.epam.task.comparator;

import com.epam.task.component.Component;
import com.epam.task.exception.ComponentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class NumberOfComponentChildrenComparator implements Comparator<Component> {
    private final static Logger LOG = LogManager.getLogger(NumberOfComponentChildrenComparator.class);

    @Override
    public int compare(Component component1, Component component2) {
        List<Component> children1 = null;
        List<Component> children2 = null;
        try {
            children1 = component1.getChild();
            children2 = component2.getChild();
        } catch (ComponentException e) {
            LOG.error("ComponentException in NumberOfComponentChildrenComparator class");
        }

        return children1.size() - children2.size();
    }
}
