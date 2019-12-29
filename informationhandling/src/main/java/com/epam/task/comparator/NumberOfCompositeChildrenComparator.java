package com.epam.task.comparator;

import com.epam.task.component.Component;
import com.epam.task.component.Composite;

import java.util.Comparator;
import java.util.List;

public class NumberOfCompositeChildrenComparator implements Comparator<Composite> {

    @Override
    public int compare(Composite component1, Composite component2) {
        List<Component> children1 = component1.getChild();
        List<Component> children2 = component2.getChild();

        return children1.size() - children2.size();
    }
}
