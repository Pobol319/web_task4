package com.epam.task.sorter;

import com.epam.task.comparator.NumberOfComponentChildrenComparator;
import com.epam.task.component.Component;

import java.util.ArrayList;
import java.util.List;

public class ParagraphSorterBySentenceNumber implements Sorter<Component> {

    @Override
    public List<Component> sort(List<Component> composites) {
        List<Component> sortable = new ArrayList<>(composites);

        sortable.sort(new NumberOfComponentChildrenComparator());

        return sortable;
    }
}